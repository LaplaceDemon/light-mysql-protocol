package sjq.light.mysql.protocol.packet;

import java.io.IOException;

import sjq.light.mysql.protocol.buffer.InputMySQLBuffer;
import sjq.light.mysql.protocol.buffer.MySQLMessage;
import sjq.light.mysql.protocol.buffer.OutputMySQLBuffer;
import sjq.light.mysql.protocol.util.LitteEndianNumberUtils;
import sjq.light.mysql.protocol.util.MySQLByteUtils;

public abstract class MySQLPacket implements ReadablePacket,WritablePacket {
    protected int length;
    protected byte sequenceId;
    
    public MySQLPacket() {
		super();
	}
    
    public MySQLPacket(int length, byte sequenceId) {
		super();
		this.length = length;
		this.sequenceId = sequenceId;
	}

	public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(byte sequenceId) {
        this.sequenceId = sequenceId;
    }
    
    public void autoSetLength() {
    	this.length = 0;
    }
    
    @Override
    public void read(InputMySQLBuffer buffer) throws IOException {
    	byte[] buf = new byte[4];
    	buffer.readNBytes(buf, 0, 4);
    	this.length = MySQLByteUtils.getPacketLength(buf);
    	this.sequenceId = buf[3];
    }
    
    @Override
    public void write(MySQLMessage message, OutputMySQLBuffer output) {
    	byte[] packetLengthBytes = LitteEndianNumberUtils.to3Bytes(this.length);
    	message.writeBytes(packetLengthBytes);
    	message.writeByte(this.sequenceId);
    }

}

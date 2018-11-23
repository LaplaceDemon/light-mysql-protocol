package sjq.light.mysql.protocol.packet.command;

import java.io.IOException;

import sjq.light.mysql.protocol.buffer.InputMySQLBuffer;
import sjq.light.mysql.protocol.buffer.MySQLMessage;
import sjq.light.mysql.protocol.buffer.OutputMySQLBuffer;
import sjq.light.mysql.protocol.packet.MySQLPacket;

public class CommandQueryPacket extends MySQLPacket {
    
    private final byte TypeFlag = 0x03;
    
    // 以0位结束符的字符串。
    private String sql;
    
    @Override
    public void read(InputMySQLBuffer buffer) throws IOException {
    	super.read(buffer);
    	
		byte typeFlagByte = buffer.readByte();
		if(this.TypeFlag != typeFlagByte) {
			throw new RuntimeException();
		}
    	
		// 读取剩余所有字节
		int sqlLen = super.length - 1;
		if(sqlLen > 0) {
			byte[] sqlBytes = buffer.readNBytes(sqlLen);
			this.sql = new String(sqlBytes);
		}
    }

    @Override
	public void write(MySQLMessage message, OutputMySQLBuffer output) {
    	super.write(message, null);
    	message.writeByte(this.TypeFlag);
    	message.writeStringEOF(this.sql);
    	output.write(message);
	}

	public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

	@Override
	public void autoSetLength() {
		this.length = 1 + this.sql.length();
	}
    
}

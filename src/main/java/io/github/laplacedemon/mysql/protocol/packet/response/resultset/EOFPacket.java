package io.github.laplacedemon.mysql.protocol.packet.response.resultset;

import java.io.IOException;

import io.github.laplacedemon.mysql.protocol.buffer.InputMySQLBuffer;
import io.github.laplacedemon.mysql.protocol.buffer.MySQLMessage;
import io.github.laplacedemon.mysql.protocol.buffer.OutputMySQLBuffer;
import io.github.laplacedemon.mysql.protocol.packet.MySQLPacket;

public class EOFPacket extends MySQLPacket {
	/**
         * 类型值，恒为254 (0xfe)
     * 1 Byte
     */
    private final byte TypeFlag = (byte)0xfe;
    /**
     * 告警计数
     * 2 Bytes
     */
    private int warnings = 0;
    /**
     * 状态标志位
     * 2 Bytes
     */
    private short statusFlags = 0;
    
    private short payload;
    
    public EOFPacket() {
        super();
    }

	@Override
	public void read(InputMySQLBuffer buffer) throws IOException {
		super.read(buffer);
		
		byte typeFlagByte = buffer.readByte();
		if(this.TypeFlag != typeFlagByte) {
			throw new RuntimeException();
		}
		
		this.warnings = buffer.readUShort();
		
		this.statusFlags = buffer.readShort();
		
		this.payload = buffer.readShort();
	}

	@Override
	public void write(MySQLMessage message, OutputMySQLBuffer output) {
		super.write(message, null);
		message.writeByte(this.TypeFlag);
		message.writeUShort(this.warnings);
		message.writeShort(this.statusFlags);
		message.writeShort(this.payload);
		
		output.write(message);
	}
	
	
    
//    @Override
//    public void write(ChannelHandlerContext ctx) {
//        ByteBuf buffer = ctx.alloc().buffer();
//        buffer.writeByte(super.sequenceId);
//        buffer.writeByte(TYPE_FLAG);
//        if((this.capabilityFlag1 & CapabilityFlag.CLIENT_PROTOCOL_41) != 0){
//            buffer.writeShort(this.warnings);
//            buffer.writeShort(this.statusFlags);
//        }
//        
//        ctx.channel().write(buffer);
//    }
}

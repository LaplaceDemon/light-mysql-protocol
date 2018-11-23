package sjq.light.mysql.protocol.packet.response.resultset;

import java.io.IOException;

import sjq.light.mysql.protocol.buffer.InputMySQLBuffer;
import sjq.light.mysql.protocol.buffer.MySQLMessage;
import sjq.light.mysql.protocol.buffer.OutputMySQLBuffer;
import sjq.light.mysql.protocol.packet.MySQLPacket;

public class ResultSetHeaderPacket extends MySQLPacket {
    /**
     * number of columns in the resultset <br>
     * 变长编码
     */
    private long filedCount;
    
    public long getFiledCount() {
        return filedCount;
    }

    public void setFiledCount(long filedCount) {
        this.filedCount = filedCount;
    }

	@Override
	public void read(InputMySQLBuffer buffer) throws IOException {
		super.read(buffer);
	}

	@Override
	public void write(MySQLMessage message, OutputMySQLBuffer output) {
		super.write(message, output);
	}

//    @Override
//    public void write(ChannelHandlerContext ctx) {
//        ByteBuf buffer = ctx.alloc().buffer();
//        buffer.writeByte(super.sequenceId);
//        NettyByteBufUtils.writeLenencInt(buffer, BigInteger.valueOf(filedCount));
//        ctx.channel().write(buffer);
//    }
    
    

}

package sjq.light.mysql.protocol.packet;

import sjq.light.mysql.protocol.buffer.MySQLMessage;
import sjq.light.mysql.protocol.buffer.OutputMySQLBuffer;

public interface WritablePacket {
	void write(MySQLMessage mysqlMessage,OutputMySQLBuffer output);
}

package sjq.light.mysql.protocol.packet;

import java.io.IOException;

import sjq.light.mysql.protocol.buffer.InputMySQLBuffer;

public interface ReadablePacket {
	void read(InputMySQLBuffer buffer) throws IOException;
}
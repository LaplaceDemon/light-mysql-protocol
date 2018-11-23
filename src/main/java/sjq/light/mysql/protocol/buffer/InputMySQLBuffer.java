package sjq.light.mysql.protocol.buffer;

import java.math.BigInteger;

public interface InputMySQLBuffer {
	int read();

	int readNBytes(byte[] buf, int offset, int len);

	/**
	 * 包括最后一个字节
	 * 
	 * @param b
	 * @return
	 */
	byte[] readUtils(byte b);

	void skip(int length);

	int readInt();

	byte[] readNBytes(int length);

	short readShort();

	byte readByte();

	BigInteger readULong();

	short readUShort();

	BigInteger readLenencInteger();

	String readLenencString();

}

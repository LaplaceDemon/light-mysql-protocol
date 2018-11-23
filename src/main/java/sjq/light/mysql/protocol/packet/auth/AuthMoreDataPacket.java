package sjq.light.mysql.protocol.packet.auth;

import java.io.IOException;

import sjq.light.mysql.protocol.buffer.InputMySQLBuffer;
import sjq.light.mysql.protocol.buffer.MySQLMessage;
import sjq.light.mysql.protocol.buffer.OutputMySQLBuffer;
import sjq.light.mysql.protocol.packet.MySQLPacket;

/**
 * https://dev.mysql.com/doc/internals/en/connection-phase-packets.html#packet-Protocol::AuthMoreData
 * 
 * @author jackie.sjq
 *
 */
public class AuthMoreDataPacket extends MySQLPacket {
	/**
	 * 
	 * 1 Byte
	 */
	private byte status = 1;
	/**
	 * - extra auth-data beyond the initial challenge string.EOF
	 */
	private String authMethodData;
	
	@Override
    public void read(InputMySQLBuffer buffer) throws IOException {
    }
    
    @Override
    public void write(MySQLMessage message, OutputMySQLBuffer output) {
    	super.write(message, null);
    	message.writeByte(status);
    	if(authMethodData != null) {
    		message.writeBytes(authMethodData.getBytes());
    	}
    	output.write(message);
    }

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getAuthMethodData() {
		return authMethodData;
	}

	public void setAuthMethodData(String authMethodData) {
		this.authMethodData = authMethodData;
	}

	@Override
	public void autoSetLength() {
		if(authMethodData == null) {
			this.length = 1;
		} else {
			this.length = 1 + authMethodData.length();
		}
	}

}

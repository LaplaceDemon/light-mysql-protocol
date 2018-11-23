package sjq.light.mysql.protocol.packet.auth;

import sjq.light.mysql.protocol.packet.MySQLPacket;

/**
 * https://dev.mysql.com/doc/internals/en/connection-phase-packets.html#packet-Protocol::AuthSwitchRequest
 * 
 * @author jackie.sjq
 *
 */
public class AuthSwitchRequestPacket extends MySQLPacket {
	private byte stauts;
	private String pluginName;
	private String authPluginData;

	public byte getStauts() {
		return stauts;
	}

	public void setStauts(byte stauts) {
		this.stauts = stauts;
	}

	public String getPluginName() {
		return pluginName;
	}

	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}

	public String getAuthPluginData() {
		return authPluginData;
	}

	public void setAuthPluginData(String authPluginData) {
		this.authPluginData = authPluginData;
	}

}

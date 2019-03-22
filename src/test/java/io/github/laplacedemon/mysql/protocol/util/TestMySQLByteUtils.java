package io.github.laplacedemon.mysql.protocol.util;

import org.junit.Test;

import io.github.laplacedemon.mysql.protocol.util.MySQLByteUtils;

public class TestMySQLByteUtils {
	
	@Test
	public void getPacketLength() {
		byte[] bs = {74, 0, 0};
		int packetLength = MySQLByteUtils.getPacketLength(bs);
		System.out.println(packetLength);
	}
}

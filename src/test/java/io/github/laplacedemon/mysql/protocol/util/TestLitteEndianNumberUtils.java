package io.github.laplacedemon.mysql.protocol.util;

import org.junit.Assert;
import org.junit.Test;

import io.github.laplacedemon.mysql.protocol.util.LitteEndianNumberUtils;

public class TestLitteEndianNumberUtils {
	
	@Test
	public void to3Bytes() {
		{
			byte[] bytes = LitteEndianNumberUtils.to3Bytes(85);
			Assert.assertArrayEquals(bytes, new byte[] {(byte)85,0,0});
		}
		{
			byte[] bytes = LitteEndianNumberUtils.to3Bytes(1024);
			Assert.assertArrayEquals(bytes, new byte[] {0,4,0});
		}
		{
			byte[] bytes = LitteEndianNumberUtils.to3Bytes(256*256*256-1);
			Assert.assertArrayEquals(bytes, new byte[] {-1,-1,-1});
		}
		
		
	}
	
	@Test
	public void toBytes() {
		byte[] bytes = LitteEndianNumberUtils.toBytes(1024);
		Assert.assertArrayEquals(bytes, new byte[] {0,4,0,0});
	}
}

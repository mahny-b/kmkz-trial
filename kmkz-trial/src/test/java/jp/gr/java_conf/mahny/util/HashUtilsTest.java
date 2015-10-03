package jp.gr.java_conf.mahny.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

/**
 * IPAのテストケースが見つからなかったので、こちらのサイトデータを元にテストを作成しました。
 * @link http://webdev.li/hash.php
 * @author mahny
 */
public class HashUtilsTest {

	/**
	 * テストというか、まんま利用方法のデモ。
	 * {@link jp.gr.java_conf.mahny.util.HashUtils#getHash(byte[])} のためのテスト・メソッド。
	 */
	@Test
	public void testGetHash() {

		// SHA-1
		{
			byte[] data = "hoge".getBytes();
			byte[] answer = DatatypeConverter.parseHexBinary("31f30ddbcb1bf8446576f0e64aa4c88a9f055e3c");
			assertThat(HashUtils.SHA1.getHash(data), is(answer));
		}

		// SHA-256
		{
			byte[] data = "hoge".getBytes();
			byte[] answer = DatatypeConverter.parseHexBinary("ecb666d778725ec97307044d642bf4d160aabb76f56c0069c71ea25b1e926825");
			assertThat(HashUtils.SHA256.getHash(data), is(answer));
		}

		// SHA-512
		{
			byte[] data = "hoge".getBytes();
			byte[] answer = DatatypeConverter.parseHexBinary("dbb50237ad3fa5b818b8eeca9ca25a047e0f29517db2b25f4a8db5f717ff90bf0b7e94ef4f5c4e313dfb06e48fbd9a2e40795906a75c470cdb619cf9c2d4f6d9");
			assertThat(HashUtils.SHA512.getHash(data), is(answer));
		}
	}
}

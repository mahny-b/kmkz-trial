package jp.gr.java_conf.mahny.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ハッシュ生成ユーティリティ
 * @author mahny
 */
public enum HashUtils {

	MD2("MD2"),
	MD5("MD5"),
	SHA1("SHA-1"),
	SHA256("SHA-256"),
	SHA384("SHA-384"),
	SHA512("SHA-512"),
	;

	private String algorithm;

	private HashUtils(String argAlgorithm) {
		algorithm = argAlgorithm;
	}

	/**
	 * 指定したハッシュを取得する
	 * @param data 暗号元データ
	 * @return ハッシュ
	 */
	public byte[] getHash(byte[] data) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			// enumで定義済みなのでJDK側で変らん限り平気
			return null;
		}
		md.reset();
		md.update(data);
		return md.digest();
	}
}

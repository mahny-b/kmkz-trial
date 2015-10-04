package jp.gr.java_conf.mahny.util;

/**
 * ByteやByte配列の為のユーティリティ
 * @author mahny
 */
public class ByteUtils {

	/**
	 * @deprecated newしちゃダメ
	 */
	@Deprecated
	private ByteUtils() {
		// nop
	}

	/**
	 * 指定した配列orgから、部分配列destを探し、そのインデックス番号を返す
	 * @param org 検索対象の配列
	 * @param dest 部分配列
	 * @param fromIndex 検索開始インデックス（負数は0と同じ）
	 * @return　インデックス番号（見つからなかったら-1）
	 */
	public static int indexOf(byte[] org, byte[] dest, int fromIndex) {

		return -1;
	}
}

package jp.gr.java_conf.mahny.util;

/**
 * ByteやByte配列の為のユーティリティ
 * @author mahny
 */
public class ByteUtils {

	private static int NOT_FOUND = -1;

	/**
	 * @deprecated newしちゃダメ
	 */
	@Deprecated
	private ByteUtils() {
		// nop
	}

	/**
	 * 指定した配列orgから、部分配列destを探し、そのインデックス番号を返す
	 * {@link http://capm-network.com/?tag=C%E8%A8%80%E8%AA%9E%E3%82%A2%E3%83%AB%E3%82%B4%E3%83%AA%E3%82%BA%E3%83%A0-BM%E6%B3%95}
	 * @param org 検索対象の配列
	 * @param dest 部分配列
	 * @param fromIndex 検索開始インデックス（負数は0と同じ）
	 * @return　インデックス番号（見つからなかったら-1）
	 */
	public static int indexOf(byte[] org, byte[] dest, int fromIndex) {

		if (fromIndex < 0) {
			fromIndex = 0;
		}
		if (isEmpty(org) || isEmpty(dest)) {
			return NOT_FOUND;
		}
		if (org.length < dest.length + fromIndex) {
			return NOT_FOUND;
		}

		// ずらし用のカンペ作成
		// 扱うデータがbyte型なので、256個確保してしまう。
		int[] skipTable = new int[Byte.MAX_VALUE - Byte.MIN_VALUE + 1];
		for (int i = 0; i < skipTable.length; i++) {
			skipTable[i] = dest.length;
		}
		for (int i = 0; i < dest.length; i++) {
			int index = dest[i] - Byte.MIN_VALUE;
			int skip = (dest.length - (i + 1) != 0) ? dest.length - (i + 1) : 1;
			skipTable[index] = (skipTable[index] == dest.length) ? skip : dest.length;
		}

		// 探索位置情報
		int beginIndex = fromIndex;
		int endIndex = org.length - dest.length + 1;	// endIndexは探索しない
		int nowIndex = beginIndex;

		// 探索
		while(nowIndex < endIndex) {
			// 後ろから探索
			for (int i = dest.length - 1; 0 <= i; i--) {
				// 検証
				if (org[nowIndex + i] != dest[i]) {
					nowIndex += skipTable[dest[i] - Byte.MIN_VALUE];
					break;
				}
				// 部分配列の最後までヒットしたので発見
				if (i == 0) {
					return nowIndex;
				}
			}
		}
		return NOT_FOUND;
	}

	/**
	 * 指定したデータがnull、または長さ0の時、trueを返す
	 * @param target 検証対象
	 * @return true:nullまたは長さ0 / false:長さ1以上
	 */
	private static boolean isEmpty(byte[] target) {
		return (target == null) || (target.length < 1);
	}
}

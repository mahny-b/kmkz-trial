/**
 *
 */
package jp.gr.java_conf.mahny.util;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author mahny
 *
 */
public class ByteUtilsTest {

	/**
	 * バリデーション
	 * orgがnull
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf01_01_01() {
		byte[] org = null;
		byte[] dest = {1, 2, 3};

		assertThat(ByteUtils.indexOf(org, dest, 0), is(-1));
	}

	/**
	 * バリデーション
	 * orgの長さ0
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf01_01_02() {
		byte[] org = {};
		byte[] dest = {1, 2, 3};

		assertThat(ByteUtils.indexOf(org, dest, 0), is(-1));
	}

	/**
	 * バリデーション
	 * destがnull
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf01_02_01() {
		byte[] org = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		byte[] dest = null;

		assertThat(ByteUtils.indexOf(org, dest, 0), is(-1));
	}

	/**
	 * バリデーション
	 * destの長さ0
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf01_02_02() {
		byte[] org = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		byte[] dest = {};

		assertThat(ByteUtils.indexOf(org, dest, 0), is(-1));
	}

	/**
	 * バリデーション
	 * fromIndexが負数（0の時と同じ挙動）
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf01_03_01() {
		byte[] org = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		byte[] dest = {4, 5, 6};

		assertThat(ByteUtils.indexOf(org, dest, Integer.MIN_VALUE), is(3));
		assertThat(ByteUtils.indexOf(org, dest, -1), is(3));
		assertThat(ByteUtils.indexOf(org, dest, 0), is(3));
	}

	/**
	 * バリデーション
	 * orgより、destが大きいので見つからない（絶対にだ）
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf01_04_01() {
		byte[] org = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		byte[] dest = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1};

		assertThat(ByteUtils.indexOf(org, dest, 0), is(-1));
	}

	/**
	 * バリデーション
	 * orgより、（dest + fromIndex）が大きいので見つからない（絶対にだ）
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf01_04_02() {
		byte[] org = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		byte[] dest = {8, 9, 0};

		assertThat(ByteUtils.indexOf(org, dest, 8), is(-1));
	}

	/**
	 * 正常系
	 * 0で見つける
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf02_01_01() {
		byte[] org = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		byte[] dest = {1, 2, 3};

		assertThat(ByteUtils.indexOf(org, dest, 0), is(0));
	}

	/**
	 * 正常系
	 * 1で見つける
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf02_01_02() {
		byte[] org = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		byte[] dest = {2, 3, 4};

		assertThat(ByteUtils.indexOf(org, dest, 0), is(1));
	}

	/**
	 * 正常系
	 * 真ん中で見つける
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf02_01_03() {
		byte[] org = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		byte[] dest = {4, 5, 6};

		assertThat(ByteUtils.indexOf(org, dest, 0), is(3));
	}

	/**
	 * 正常系
	 * 最後に見つける
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf02_01_04() {
		byte[] org = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		byte[] dest = {8, 9, 0};

		assertThat(ByteUtils.indexOf(org, dest, 0), is(7));
	}

	/**
	 * 正常系
	 * fromIndex
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf02_02_01() {
		byte[] org = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		byte[] dest = {4, 5, 6};

		assertThat(ByteUtils.indexOf(org, dest, 0), is(3));
		assertThat(ByteUtils.indexOf(org, dest, 1), is(3));
		assertThat(ByteUtils.indexOf(org, dest, 3), is(3));
		assertThat(ByteUtils.indexOf(org, dest, 4), is(-1));
	}

	/**
	 * 正常系
	 * fromIndex（検索候補が複数）
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf02_02_02() {
		byte[] org = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 4, 5, 6, 7};
		byte[] dest = {4, 5, 6};

		assertThat(ByteUtils.indexOf(org, dest, 3), is(3));
		assertThat(ByteUtils.indexOf(org, dest, 4), is(10));
		assertThat(ByteUtils.indexOf(org, dest, 9), is(10));
		assertThat(ByteUtils.indexOf(org, dest, 10), is(10));
		assertThat(ByteUtils.indexOf(org, dest, 11), is(-1));
	}

	/**
	 * 正常系
	 * カンペいじめ
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf02_03_01() {
		byte[] org = {
			1, 2, 3, 4, 5, 1, 2, 1, 3, 2,
			4, 5, 4, 3, 2, 1, 1, 2, 1, 3,
			2, 4, 5, 9, 0, 1, 2, 3, 4, 5
		};
		byte[] dest = {1, 2, 1, 3, 2, 4, 5};

		// 答えは、5、16
		assertThat(ByteUtils.indexOf(org, dest, 4), is(5));
		assertThat(ByteUtils.indexOf(org, dest, 5), is(5));
		assertThat(ByteUtils.indexOf(org, dest, 6), is(16));
		assertThat(ByteUtils.indexOf(org, dest, 16), is(16));
		assertThat(ByteUtils.indexOf(org, dest, 17), is(-1));
	}

	/**
	 * カンペ実装に対する確認用
	 */
	@Test
	@Ignore("実装時の確認用なのでスキップ")
	public void skipTableImplTest() {
		byte[] dest = {-128, 5, 6, 4, 5, 6, 127};

		int[] skipTable = new int[Byte.MAX_VALUE - Byte.MIN_VALUE + 1];
		for (int i = 0; i < skipTable.length; i++) {
			skipTable[i] = dest.length;
		}
		for (int i = 0; i < dest.length; i++) {
			int index = dest[i] - Byte.MIN_VALUE;
			int skip = (dest.length - (i + 1) != 0) ? dest.length - (i + 1) : 1;
			if (skip < skipTable[index]) {
				skipTable[index] = skip;
			}
		}

		assertThat(skipTable[-128 - Byte.MIN_VALUE], is(6));
		for (int i = -127; i < 4; i++) {
			assertThat(skipTable[i - Byte.MIN_VALUE], is(dest.length));
		}
		assertThat(skipTable[4 - Byte.MIN_VALUE], is(3));
		assertThat(skipTable[5 - Byte.MIN_VALUE], is(2));
		assertThat(skipTable[6 - Byte.MIN_VALUE], is(1));
		for (int i = 7; i < 127; i++) {
			assertThat(skipTable[i - Byte.MIN_VALUE], is(dest.length));
		}
		assertThat(skipTable[127 - Byte.MIN_VALUE], is(1));
	}
}

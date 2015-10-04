/**
 *
 */
package jp.gr.java_conf.mahny.util;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

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
}

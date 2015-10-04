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
	 * 正常系
	 * {@link jp.gr.java_conf.mahny.util.ByteUtils#indexOf(byte[], byte[], int)} のためのテスト・メソッド。
	 */
	@Test
	public void testIndexOf() {

		// ★バリデーション系
		// orgがnull
		// orgが長さ0
		// orgが適当な長さ
		// destがnull
		// destが長さ0
		// destが適当な長さ
		// fromIndexが負数
		// fromIndexが0
		// fromIndexが整数
		// orgより、destが大きい（fromIndex > 0だと条件変わるから注意）

		// ★正常系
		// 0で見つける
		byte[] org = {1, 2, 3, 4, 5};
		byte[] dest = {1, 2, 3, 4, 5};
		assertThat(ByteUtils.indexOf(org, dest, 0), is(0));

		// 1で見つける

		// 真ん中あたりで見つける

		// 最後に見つける

		// 見つからない
	}

}

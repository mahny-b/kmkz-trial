package jp.gr.java_conf.mahny.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author mahny
 *
 */
public class DateCalculaterTest {

	/**
	 * 利用方法デモ
	 *
	 * @throws ParseException
	 */
	@Test
	public void demo() throws ParseException {

		// この書き方は、これとほぼ同じ
		// Calendar cal = Calendar.getInstance();
		{
			Calendar cal = DateCalculater.getInstance().toCalendar();
			assertThat(cal, instanceOf(Calendar.class));
		}

		// Date型の方がいいなって時はこっち
		{
			Date date = DateCalculater.getInstance().toDate();
			assertThat(date, instanceOf(Date.class));
		}

		// 1時間後のCalendarが欲しい
		{
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = DateCalculater.getInstance().addHour(1).toCalendar();

			// 23時以降にやると右の引数が24になるのでミスる
			assertThat(cal2.get(Calendar.HOUR_OF_DAY), is(cal1.get(Calendar.HOUR_OF_DAY) + 1));
		}

		// 特定の日時の1日前のDateが欲しい
		{
			Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-01 12:34:56.789");
			Date date2 = DateCalculater.getInstance(date1.getTime()).addDate(-1).toDate();

			String date2str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date2);
			assertThat(date2str, is("2015-08-31 12:34:56.789"));
		}
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#getInstance()}
	 * のためのテスト・メソッド。
	 */
	@Test
	@Ignore("#getInstance(long, java.util.TimeZone, java.util.Locale)を呼ぶだけなのでスキップ")
	public void testGetInstance() {
		// nop
	}

	/**
	 * バリデーション系 millis（負数）
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#getInstance(long, java.util.TimeZone, java.util.Locale)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testGetInstanceLongTimeZoneLocale01_01() {

	}

	/**
	 * バリデーション系 millis（0）
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#getInstance(long, java.util.TimeZone, java.util.Locale)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testGetInstanceLongTimeZoneLocale() {

		// バリデーション系
		// millis
		// 負数
		// 0
		// 整数（大昔）
		// 整数（今くらい）
		// 整数（超絶未来）

		// zone
		// null
		// なんか指定

		// locale
		// null
		// なんか指定
	}

	/**
	 * バリデーション系 millis（大昔）
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#getInstance(long, java.util.TimeZone, java.util.Locale)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testGetInstanceLongTimeZoneLocale() {

		// バリデーション系
		// millis
		// 負数
		// 0
		// 整数（大昔）
		// 整数（今くらい）
		// 整数（超絶未来）

		// zone
		// null
		// なんか指定

		// locale
		// null
		// なんか指定
	}

	/**
	 * バリデーション系 millis（今くらい）
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#getInstance(long, java.util.TimeZone, java.util.Locale)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testGetInstanceLongTimeZoneLocale() {

		// バリデーション系
		// millis
		// 負数
		// 0
		// 整数（大昔）
		// 整数（今くらい）
		// 整数（超絶未来）

		// zone
		// null
		// なんか指定

		// locale
		// null
		// なんか指定
	}

	/**
	 * バリデーション系 millis（超絶未来）
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#getInstance(long, java.util.TimeZone, java.util.Locale)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testGetInstanceLongTimeZoneLocale() {

		// バリデーション系
		// millis
		// 負数
		// 0
		// 整数（大昔）
		// 整数（今くらい）
		// 整数（超絶未来）

		// zone
		// null
		// なんか指定

		// locale
		// null
		// なんか指定
	}

	/**
	 * 正常系
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#getInstance(long, java.util.TimeZone, java.util.Locale)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testGetInstanceLongTimeZoneLocale() {

		// バリデーション系
		// millis
		// 負数
		// 0
		// 整数（大昔）
		// 整数（今くらい）
		// 整数（超絶未来）

		// zone
		// null
		// なんか指定

		// locale
		// null
		// なんか指定
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#getInstance(long)}
	 * のためのテスト・メソッド。
	 */
	@Test
	@Ignore("#getInstance(long, java.util.TimeZone, java.util.Locale)を呼ぶだけなのでスキップ")
	public void testGetInstanceLong() {
		// nop
	}

	/**
	 * 正常系 払い出し {@link jp.gr.java_conf.mahny.util.DateCalculater#toCalendar()}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testToCalendar() {
		assertThat(DateCalculater.getInstance().toCalendar(), instanceOf(Calendar.class));
	}

	/**
	 * 正常系 払い出し {@link jp.gr.java_conf.mahny.util.DateCalculater#toDate()}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testToDate() {
		assertThat(DateCalculater.getInstance().toDate(), instanceOf(Date.class));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addYear(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testAddYear() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addMonth(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testAddMonth() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addDate(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testAddDate() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addHour(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testAddHour() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addMin(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testAddMin() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addSec(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testAddSec() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addMSec(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testAddMSec() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setYear(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testSetYear() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setMonth(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testSetMonth() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setDate(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testSetDate() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setHour(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testSetHour() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setMin(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testSetMin() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setSec(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testSetSec() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setMSec(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testSetMSec() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollYear(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testRollYear() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollMonth(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testRollMonth() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollDate(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testRollDate() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollHour(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testRollHour() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollMin(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testRollMin() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollSec(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testRollSec() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollMSec(int)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testRollMSec() {
		fail("まだ実装されていません");
	}

}

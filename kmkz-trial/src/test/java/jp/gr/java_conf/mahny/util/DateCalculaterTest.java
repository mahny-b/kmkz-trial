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

			if (cal1.get(Calendar.HOUR_OF_DAY) < 23) {
				assertThat(cal2.get(Calendar.HOUR_OF_DAY), is(cal1.get(Calendar.HOUR_OF_DAY) + 1));
			} else {
				assertThat(cal2.get(Calendar.HOUR_OF_DAY), is(0));
			}
		}

		// 特定の日時の1日と1分前のDateが欲しい
		{
			Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789");
			Date date2 = DateCalculater.getInstance(date1.getTime()).addDate(-1).addMin(-1).toDate();

			String date2str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date2);
			assertThat(date2str, is("2015-09-14 12:33:56.789"));
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
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#getInstance(long, java.util.TimeZone, java.util.Locale)}
	 * のためのテスト・メソッド。
	 */
	@Test
	@Ignore("たらい回しですね。分かります")
	public void testGetInstanceLongTimeZoneLocale() {
		// nop
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
	 * 正常系
	 * 払い出し
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#toCalendar()}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testToCalendar() {
		// 実行＋検証
		assertThat(DateCalculater.getInstance().toCalendar(), instanceOf(Calendar.class));
	}

	/**
	 * 正常系
	 * 払い出し
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#toDate()}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testToDate() {
		// 実行＋検証
		assertThat(DateCalculater.getInstance().toDate(), instanceOf(Date.class));
	}

	/**
	 * 正常系
	 * +1
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addYear(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testAddYear01_01() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).addYear(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2016-09-15 12:34:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addYear(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testAddYear() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).addYear(0).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-15 12:34:56.789"));
	}

	/**
	 * 正常系
	 * +1
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addMonth(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testAddMonth01_01() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).addMonth(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-10-15 12:34:56.789"));
	}

	/**
	 * 正常系
	 * +1で繰り上がる
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addMonth(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testAddMonth01_02() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-12-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).addMonth(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2016-01-15 12:34:56.789"));
	}

	/**
	 * 正常系
	 * -1
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addMonth(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testAddMonth01_03() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).addMonth(-1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-08-15 12:34:56.789"));
	}

	/**
	 * 正常系
	 * -1で繰り下がる
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addMonth(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testAddMonth01_04() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-01-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).addMonth(-1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2014-12-15 12:34:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addDate(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testAddDate() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).addDate(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-16 12:34:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addHour(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testAddHour() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).addHour(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-15 13:34:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addMin(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testAddMin() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).addMin(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-15 12:35:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addSec(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testAddSec() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).addSec(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-15 12:34:57.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#addMSec(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testAddMSec() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).addMSec(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-15 12:34:56.790"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setYear(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testSetYear() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).setYear(2020).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2020-09-15 12:34:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setMonth(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testSetMonth() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).setMonth(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-02-15 12:34:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setDate(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testSetDate() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).setDate(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-01 12:34:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setHour(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testSetHour() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).setHour(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-15 01:34:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setMin(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testSetMin() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).setMin(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-15 12:01:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setSec(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testSetSec() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).setSec(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-15 12:34:01.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#setMSec(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testSetMSec() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).setMSec(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-15 12:34:56.001"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollYear(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testRollYear() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).rollYear(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2016-09-15 12:34:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollMonth(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testRollMonth() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).rollMonth(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-10-15 12:34:56.789"));
	}

	/**
	 * 正常系
	 * +1
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollDate(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testRollDate01_01() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).rollDate(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-16 12:34:56.789"));
	}

	/**
	 * 正常系
	 * +1 繰り上がりがあるけど、月に影響しない
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollDate(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testRollDate01_02() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-30 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).rollDate(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-01 12:34:56.789"));
	}

	/**
	 * 正常系
	 * -1
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollDate(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testRollDate01_03() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).rollDate(-1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-14 12:34:56.789"));
	}

	/**
	 * 正常系
	 * -1 繰り下がりがあるけど、月に影響しない
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollDate(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testRollDate01_04() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-01 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).rollDate(-1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-30 12:34:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollHour(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testRollHour() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).rollHour(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-15 13:34:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollMin(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testRollMin() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).rollMin(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-15 12:35:56.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollSec(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testRollSec() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).rollSec(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-15 12:34:57.789"));
	}

	/**
	 * {@link jp.gr.java_conf.mahny.util.DateCalculater#rollMSec(int)}
	 * のためのテスト・メソッド。
	 * @throws ParseException
	 */
	@Test
	public void testRollMSec() throws ParseException {
		// 準備
		long msec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-09-15 12:34:56.789").getTime();

		// 実行
		Date date = DateCalculater.getInstance(msec).rollMSec(1).toDate();

		// 検証
		String resultStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
		assertThat(resultStr, is("2015-09-15 12:34:56.790"));
	}

}

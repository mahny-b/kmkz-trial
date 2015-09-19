package jp.gr.java_conf.mahny.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * チェーンなノリでDateやCalendarオブジェクトを作るユーティリティ。
 * ぬるぽは遠慮無くRuntimeExceptionを投げるのでご注意。
 * @author mahny
 */
public class DateCalculater {
	
	private Calendar cal;

	/**
	 * 初期化
	 * @param targetCalendar
	 */
	private DateCalculater(Calendar targetCalendar) {
		cal = targetCalendar;
	}

	/**
	 * インスタンスを生成
	 * @return 本インスタンス
	 */
	public static DateCalculater getInstance() {
		return getInstance(System.currentTimeMillis(), null, null);
	}
	
	/**
	 * インスタンスを生成
	 * @param millis ミリ秒
	 * @param zone タイムゾーン（null指定時はデフォルトタイムゾーンを使う）
	 * @param locale ロケール（null指定時はデフォルトロケールを使う）
	 * @return 本インスタンス
	 */
	public static DateCalculater getInstance(long millis, TimeZone zone, Locale locale) {
		if (zone == null) {
			zone = TimeZone.getDefault();
		}
		if (locale == null) {
			locale = Locale.getDefault();
		}
		Calendar cal = Calendar.getInstance(zone, locale);
		cal.setTimeInMillis(millis);
		return new DateCalculater(cal);
	}

	/**
	 * インスタンスを生成
	 * @param millis ミリ秒
	 * @return 本インスタンス
	 */
	public static DateCalculater getInstance(long millis) {
		return getInstance(millis, null, null);
	}

	/**
	 * Calendarオブジェクトを返す
	 * @return Calendarオブジェクト
	 */
	public Calendar toCalendar() {
		return cal;
	}
	
	/**
	 * カレンダーオブジェクトを返す
	 * @return カレンダーオブジェクト
	 */
	public Date toDate() {
		return cal.getTime();
	}
	
	/**
	 * 指定した値を加算する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater addYear(int value) {
		cal.add(Calendar.YEAR, value);
		return this;
	}
	
	/**
	 * 指定した値を加算する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater addMonth(int value) {
		cal.add(Calendar.MONTH, value);
		return this;
	}
	
	/**
	 * 指定した値を加算する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater addDate(int value) {
		cal.add(Calendar.DATE, value);
		return this;
	}
	
	/**
	 * 指定した値を加算する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater addHour(int value) {
		cal.add(Calendar.HOUR_OF_DAY, value);
		return this;
	}
	
	/**
	 * 指定した値を加算する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater addMin(int value) {
		cal.add(Calendar.MINUTE, value);
		return this;
	}
	
	/**
	 * 指定した値を加算する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater addSec(int value) {
		cal.add(Calendar.SECOND, value);
		return this;
	}
	
	/**
	 * 指定した値を加算する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater addMSec(int value) {
		cal.add(Calendar.MILLISECOND, value);
		return this;
	}
	
	/**
	 * 指定した値を設定する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater setYear(int value) {
		cal.set(Calendar.YEAR, value);
		return this;
	}
	
	/**
	 * 指定した値を設定する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater setMonth(int value) {
		cal.set(Calendar.MONTH, value);
		return this;
	}
	
	/**
	 * 指定した値を設定する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater setDate(int value) {
		cal.set(Calendar.DATE, value);
		return this;
	}
	
	/**
	 * 指定した値を設定する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater setHour(int value) {
		cal.set(Calendar.HOUR_OF_DAY, value);
		return this;
	}
	
	/**
	 * 指定した値を設定する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater setMin(int value) {
		cal.set(Calendar.MINUTE, value);
		return this;
	}
	
	/**
	 * 指定した値を設定する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater setSec(int value) {
		cal.set(Calendar.SECOND, value);
		return this;
	}
	
	/**
	 * 指定した値を設定する
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater setMSec(int value) {
		cal.set(Calendar.MILLISECOND, value);
		return this;
	}
	
	/**
	 * 指定した値を加算する（他のフィールドに影響しない）
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater rollYear(int value) {
		cal.roll(Calendar.YEAR, value);
		return this;
	}
	
	/**
	 * 指定した値を加算する（他のフィールドに影響しない）
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater rollMonth(int value) {
		cal.roll(Calendar.MONTH, value);
		return this;
	}
	
	/**
	 * 指定した値を加算する（他のフィールドに影響しない）
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater rollDate(int value) {
		cal.roll(Calendar.DATE, value);
		return this;
	}
	
	/**
	 * 指定した値を加算する（他のフィールドに影響しない）
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater rollHour(int value) {
		cal.roll(Calendar.HOUR_OF_DAY, value);
		return this;
	}
	
	/**
	 * 指定した値を加算する（他のフィールドに影響しない）
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater rollMin(int value) {
		cal.roll(Calendar.MINUTE, value);
		return this;
	}
	
	/**
	 * 指定した値を加算する（他のフィールドに影響しない）
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater rollSec(int value) {
		cal.roll(Calendar.SECOND, value);
		return this;
	}
	
	/**
	 * 指定した値を加算する（他のフィールドに影響しない）
	 * @param value 値
	 * @return 本オブジェクト
	 */
	public DateCalculater rollMSec(int value) {
		cal.roll(Calendar.MILLISECOND, value);
		return this;
	}
	
}

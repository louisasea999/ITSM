package com.yum.itsm.ddtalk.common.ws;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustDateFormat extends SimpleDateFormat {
//	private SimpleDateFormat defaultFormatter = new SimpleDateFormat();

	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

	private SimpleDateFormat timestampFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public CustDateFormat() {
		super();
	}

	public CustDateFormat(String pattern) {
		super(pattern);
	}

	public CustDateFormat(String pattern,
												Locale locale) {
		super(pattern, locale);
	}

	public CustDateFormat(String pattern,
												DateFormatSymbols formatSymbols) {
		super(pattern, formatSymbols);
	}

	@Override
	public StringBuffer format(	Date date,
															StringBuffer toAppendTo,
															FieldPosition fieldPosition) {
		return super.format(date,
												toAppendTo,
												fieldPosition);
	}

	@Override
	public Date parse(String source,
										ParsePosition pos) {
		String strVal = source.trim();
		if (strVal.length() == "yyyy-MM-dd".length())
			return new SimpleDateFormat("yyyy-MM-dd").parse(source,
																											pos);
		if (strVal.length() == "yyyy-MM-dd HH:mm:ss".length())
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(	source,
																																pos);

		return super.parse(	strVal,
												pos);
	}

	/**
	 * Overrides Cloneable
	 */
	public Object clone() {
		DateFormat other = (DateFormat)super.clone();
		return other;
	}

}

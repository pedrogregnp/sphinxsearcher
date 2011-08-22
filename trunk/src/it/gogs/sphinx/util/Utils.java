package it.gogs.sphinx.util;

import it.gogs.sphinx.DateRange;

import java.util.Date;
import java.util.List;

public class Utils {

	public static final String HOST = "192.168.75.128";

	public static final boolean isEmpty(String key) {
		if (key == null || key.isEmpty()) {
			return true;
		}
		return false;
	}

	public static final String toCommaString(List addressIds) {
		StringBuffer sb = new StringBuffer();
		for (Object object : addressIds) {
			sb.append(object);
			sb.append(",");
		}
		int length = sb.length();
		if (length > 0) {
			sb.deleteCharAt(length - 1);
		}
		return sb.toString();
	}

	public static final boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}
		return false;
	}

	public static final boolean isDateRangeValid(DateRange dateRange) {
		if (dateRange == null) {
			return false;
		}
		Date fromDate = dateRange.getFromDate();
		Date toDate = dateRange.getToDate();

		if (fromDate == null || toDate == null) {
			return false;
		}

		if (fromDate.getTime() < toDate.getTime()) {
			return true;
		}

		return false;
	}

}

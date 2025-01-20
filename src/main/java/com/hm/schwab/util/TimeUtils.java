package com.hm.schwab.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
	public static String getTimeFormat(LocalDateTime ldt) {
        // Convert LocalDateTime to ZonedDateTime using the system default time zone
        ZonedDateTime zonedDateTime = ldt.atZone(ZoneId.systemDefault());

        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

        // Format the ZonedDateTime to the desired format
        String zdt = zonedDateTime.format(formatter) + "Z";
        try {
			return URLEncoder.encode(zdt, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null; //should never get here
	}

    public static long toEpochMillis(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}

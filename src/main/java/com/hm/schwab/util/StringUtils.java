package com.hm.schwab.util;

import java.util.Set;

public class StringUtils {
	public static void addStringsToSet(String commaseplist, Set<String> strset) {
        String[] strarr = commaseplist.split(",'");
        for(String str : strarr) {
        	strset.add(str);
        }
	}
}

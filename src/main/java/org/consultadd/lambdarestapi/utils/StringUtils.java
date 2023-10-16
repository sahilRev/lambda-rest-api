package org.consultadd.lambdarestapi.utils;

public class StringUtils {

    public static String strip(String s) {
        if (null == s || "".equals(s)) {
            return "";
        }
        return s.strip();
    }

}

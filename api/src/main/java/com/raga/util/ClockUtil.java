package com.raga.util;

import java.sql.Timestamp;
import java.util.Date;

public class ClockUtil {

    public static Timestamp now() {
        return new Timestamp(new Date().getTime());
    }
}

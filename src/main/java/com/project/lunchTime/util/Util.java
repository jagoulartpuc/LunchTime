package com.project.lunchTime.util;

import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class Util {

    public int getWeekday() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    public int getMonthNumber() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH);
    }

}

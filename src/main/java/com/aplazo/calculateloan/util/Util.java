package com.aplazo.calculateloan.util;

import java.util.Calendar;
import java.util.Date;

public class Util {

    public static Date addWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        return calendar.getTime();
    }

    public static Double calculatePay(Double amount, Double rate, Integer terms) {
        Double rateWeekly = amount * (rate / 100);
        return (amount / terms) + rateWeekly;
    }
}

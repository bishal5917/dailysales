package com.example.dailysales.utils;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class DateUtil {

    public static String getMonth() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getMonth().toString();
    }

    public static int getDay() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getDayOfMonth();
    }

    public static int getYear() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getYear();
    }

    public static String getDate() {
        LocalDate currentDate = LocalDate.now();
        Month month = currentDate.getMonth();
        int day = currentDate.getDayOfMonth();
        int yr = currentDate.getYear();
        return day + " " + month.toString() + ", " + yr;
    }

    public static String getGreetingMessage() {
        Calendar c = Calendar.getInstance();
        int hourOfDay = c.get(Calendar.HOUR_OF_DAY);
        if (hourOfDay >= 0 && hourOfDay <= 11) {
            return "Good Morning, Ram !";
        } else if (hourOfDay >= 12 && hourOfDay <= 15) {
            return "Good Afternoon, Ram !";
        } else if (hourOfDay >= 16 && hourOfDay <= 19) {
            return "Good Evening, Ram !";
        } else if (hourOfDay >= 20 && hourOfDay <= 23) {
            return "Good Night, Ram !";
        } else {
            return "Welcome, Ram !";
        }
    }

    public static long getDateOnlyTimestamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static long getStartOfDayFiveDaysAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -5);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }
}

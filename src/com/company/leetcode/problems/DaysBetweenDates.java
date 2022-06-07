package com.company.leetcode.problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DaysBetweenDates {

    public  int daysBetweenDates(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate t1 = LocalDate .parse(date1,formatter);
        LocalDate  t2 = LocalDate .parse(date2,formatter);
        long days1 = t1.until(t2, ChronoUnit.DAYS);
        return Math.abs((int)days1);
    }
}

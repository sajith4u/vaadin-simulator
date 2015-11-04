package dev.innova.test;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;


public class TestClass {
    private static final Long MILLISECONDS_IN_SECOND = 1000L;

    @Test
    public void getDate() {

        Date lowerBoundDate = getHigherBoundDate();
        Date lower = getLowerBoundDate();
        Date current = currentTimeSTamp();
        java.sql.Date sqlLowerDate = new java.sql.Date(lowerBoundDate.getTime());
        java.sql.Date sql = new java.sql.Date(lower.getTime());
        java.sql.Date currentMap = new java.sql.Date(current.getTime());
        System.out.println("TimeStamp High : " + sqlLowerDate.getTime() / MILLISECONDS_IN_SECOND);
        System.out.println("TimeStamp Low : " + sql.getTime() / MILLISECONDS_IN_SECOND);
        System.out.println("Current Low : " + currentMap.getTime() / MILLISECONDS_IN_SECOND);
    }

    protected Date getHigherBoundDate() {
        Calendar higherBoundCalendar = Calendar.getInstance();
        higherBoundCalendar.set(Calendar.HOUR_OF_DAY, 15);
        higherBoundCalendar.set(Calendar.MINUTE, 59);
        higherBoundCalendar.set(Calendar.MILLISECOND, 999);
        return higherBoundCalendar.getTime();
    }

    protected Date getLowerBoundDate() {
        Calendar lowerBoundCalendar = Calendar.getInstance();
        lowerBoundCalendar.add(Calendar.WEEK_OF_MONTH,-2);
        lowerBoundCalendar.set(Calendar.HOUR_OF_DAY, 12);
        lowerBoundCalendar.set(Calendar.MINUTE, 20);
        lowerBoundCalendar.set(Calendar.MILLISECOND, 0);
        return lowerBoundCalendar.getTime();
    }

    protected Date currentTimeSTamp() {
        Calendar lowerBoundCalendar = Calendar.getInstance();
        lowerBoundCalendar.set(Calendar.HOUR_OF_DAY, 16);
        lowerBoundCalendar.set(Calendar.MINUTE, 20);
        lowerBoundCalendar.set(Calendar.MILLISECOND, 0);
        return lowerBoundCalendar.getTime();
    }
}

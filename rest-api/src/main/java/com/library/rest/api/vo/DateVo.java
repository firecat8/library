package com.library.rest.api.vo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gdimitrova
 */
public class DateVo implements Serializable, Validatable {

    private int month;

    private int day;

    private int year;

    private int hour;

    private int minutes;

    private int seconds;

    private int miliseconds;

    public DateVo() {

    }

    public DateVo(Calendar date) {
        setDate(date);
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMiliseconds() {
        return miliseconds;
    }

    public void setDate(Calendar date) {
        this.year = date.get(Calendar.YEAR) - 1900;
        this.month = date.get(Calendar.MONTH);
        this.day = date.get(Calendar.DAY_OF_MONTH);
        this.hour = date.get(Calendar.HOUR_OF_DAY);
        this.minutes = date.get(Calendar.MINUTE);
        this.seconds = date.get(Calendar.SECOND);
        this.miliseconds = date.get(Calendar.MILLISECOND);
    }

    public Calendar convetToCalendar() {
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.set(Calendar.YEAR, year + 1900);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minutes);
        c.set(Calendar.SECOND, seconds);
        c.set(Calendar.MILLISECOND, miliseconds);
        return c;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.month;
        hash = 53 * hash + this.day;
        hash = 53 * hash + this.year;
        hash = 53 * hash + this.hour;
        hash = 53 * hash + this.minutes;
        hash = 53 * hash + this.seconds;
        hash = 53 * hash + this.miliseconds;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DateVo other = (DateVo) obj;
        if (this.month != other.month) {
            return false;
        }
        if (this.day != other.day) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (this.hour != other.hour) {
            return false;
        }
        if (this.minutes != other.minutes) {
            return false;
        }
        if (this.seconds != other.seconds) {
            return false;
        }
        return this.miliseconds == other.miliseconds;
    }

    @Override
    public Set<String> validate() {
        Set<String> errors = new HashSet<>();
        try{
        convetToCalendar();
        }catch(Exception ex){
            errors.add(ex.getMessage());
        }
        return errors;
    }

}

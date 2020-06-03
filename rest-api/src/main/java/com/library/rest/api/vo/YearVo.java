package com.library.rest.api.vo;

import java.io.Serializable;

/**
 *
 * @author gdimitrova
 */
public class YearVo implements Serializable{
    private int year;

    public YearVo() {
    }

    public YearVo(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.valueOf(year);
    }

    
}

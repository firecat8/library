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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.year;
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
        final YearVo other = (YearVo) obj;
        if (this.year != other.year) {
            return false;
        }
        return true;
    }

    
}

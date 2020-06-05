/*
 * Project library
 */
package com.library.bl.rest.impl.vo.exchanger;

import com.library.rest.api.vo.DateVo;
import java.util.Calendar;

/**
 *
 * @author gdimitrova
 */
public class DateVoExchanger {

    public final static DateVoExchanger INSTANCE = new DateVoExchanger();

    private DateVoExchanger() {
    }

    public Calendar exchange(DateVo d) {
        return d == null ? null : d.convetToCalendar();
    }

    public DateVo exchange(Calendar d) {
        return d == null ? null : new DateVo(d);
    }

}

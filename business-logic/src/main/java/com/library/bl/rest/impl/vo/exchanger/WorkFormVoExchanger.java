/*
 * Project library
 */
package com.library.bl.rest.impl.vo.exchanger;

import com.library.domain.book.WorkForm;
import com.library.rest.api.vo.book.WorkFormVo;

/**
 *
 * @author gdimitrova
 */
public class WorkFormVoExchanger extends VoEntityExchanger<WorkFormVo, WorkForm> {

    public final static WorkFormVoExchanger INSTANCE = new WorkFormVoExchanger();

    private WorkFormVoExchanger() {
    }

    @Override
    protected WorkForm exchangeFrom(WorkFormVo Vo) {
        return new WorkForm(Vo.getName());
    }

    @Override
    protected WorkFormVo exchangeFrom(WorkForm e) {
        return new WorkFormVo(e.getName());
    }

}

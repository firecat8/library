/*
 * Project library
 */
package com.library.dto.exchanger;

import com.library.domain.book.WorkForm;
import com.library.dto.WorkFormDto;

/**
 *
 * @author gdimitrova
 */
public class WorkFormDtoExchanger extends DtoEntityExchanger<WorkFormDto, WorkForm> {

    public final static WorkFormDtoExchanger INSTANCE = new WorkFormDtoExchanger();

    private WorkFormDtoExchanger() {
    }

    @Override
    protected WorkForm exchangeFrom(WorkFormDto dto) {
        return new WorkForm(dto.getName());
    }

    @Override
    protected WorkFormDto exchangeFrom(WorkForm e) {
        return new WorkFormDto(e.getName());
    }

}

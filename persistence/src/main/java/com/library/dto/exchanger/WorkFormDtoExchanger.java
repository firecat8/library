/*
 * Project library
 */
package com.library.dto.exchanger;

import com.library.domain.WorkForm;
import com.library.dto.WorkFormDto;

/**
 *
 * @author gdimitrova
 */
public class WorkFormDtoExchanger extends DtoEntityExchanger<WorkFormDto, WorkForm> {

    @Override
    protected WorkForm exchangeFrom(WorkFormDto dto) {
        return new WorkForm(dto.getName());
    }

    @Override
    protected WorkFormDto exchangeFrom(WorkForm e) {
        return new WorkFormDto(e.getName());
    }

}

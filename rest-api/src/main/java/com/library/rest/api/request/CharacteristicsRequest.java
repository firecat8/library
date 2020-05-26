package com.library.rest.api.request;

import com.library.domain.book.Characteristic;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class CharacteristicsRequest extends EntityListRequest<Characteristic> {

    public CharacteristicsRequest(List<Characteristic> entities) {
        super(entities);
    }

}

/*
 * Project library
 */
package com.library.persistence;

import com.library.dao.DaoRegistry;
import com.library.dao.book.CharacteristicDaoImpl;
import com.library.domain.Characteristic;
import com.library.dto.CharacteristicDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class CharacteristicDaoTestCase extends AbstractCrudDaoTestCase<CharacteristicDto, Characteristic, CharacteristicDaoImpl> {

    @Override
    protected Characteristic createEntity() {
        return createEntity("Humor");
    }

    @Override
    protected List<Characteristic> createEntities() {
        return createCharacteristics();
    }

    @Override
    protected CharacteristicDaoImpl  getDao(DaoRegistry registry) {
        return (CharacteristicDaoImpl) registry.getCharacteristicDao();
    }

    private static Characteristic createEntity(String name) {
        return new Characteristic(name);
    }

    public static List<Characteristic> createCharacteristics() {
        List<Characteristic> characteristics = new ArrayList<>();
        characteristics.add(createEntity("Black Humor"));
        characteristics.add(createEntity("Dramatism"));
        return characteristics;
    }

    @Override
    protected void prepareDbData() {
    }
}

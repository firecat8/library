package com.library.server;

import com.library.rest.api.service.CharacteristicRestService;
import com.library.rest.api.vo.book.CharacteristicVo;
import com.library.rest.api.vo.list.CharacteristicsListVo;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author gdimitrova
 */
public class IntegrationCharacteristicRestServiceTest
        extends IntegrationAbstractCrudRestServiceTest<CharacteristicVo, CharacteristicsListVo, CharacteristicRestService> {

    public IntegrationCharacteristicRestServiceTest() {
        super(CharacteristicVo.class, CharacteristicsListVo.class);
    }

    @Override
    protected CharacteristicVo createVo() {
        return createDefault();
    }

    @Override
    protected CharacteristicRestService getRestService() {
        return proxy.getCharacteristicsRestService();
    }

    @Override
    protected CharacteristicsListVo createListVo() {
        return createCharacteristics();
    }

    @Override
    protected void assertVos(CharacteristicVo expected, CharacteristicVo actual, boolean isSaveAction) {
        if (!isSaveAction) {
            assertEquals(expected, actual);
            return;
        }
        assertEquals(expected.getName(), actual.getName());
    }

    @Override
    protected void prepareData() {
    }

    private static CharacteristicVo createVo(String name) {
        return new CharacteristicVo(name);
    }

    public static CharacteristicVo createDefault() {
        return createVo("Novel");
    }

    public static CharacteristicsListVo createCharacteristics() {
        List<CharacteristicVo> workForms = new ArrayList<>();
        workForms.add(createVo("Biography"));
        workForms.add(createVo("Poem"));
        return new CharacteristicsListVo(workForms);
    }

}

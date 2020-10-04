package com.library.server.stress.book;

import com.library.rest.api.RootResource;
import com.library.rest.api.service.CharacteristicRestService;
import com.library.rest.api.vo.book.CharacteristicVo;
import com.library.rest.api.vo.list.CharacteristicsListVo;
import com.library.server.stress.StressAbstractCrudRestServiceTest;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author gdimitrova
 */
public class StressCharacteristicRestServiceTest
        extends StressAbstractCrudRestServiceTest<CharacteristicVo, CharacteristicsListVo, CharacteristicRestService> {

    public StressCharacteristicRestServiceTest() {
        super(CharacteristicVo.class, CharacteristicsListVo.class);
    }

    @Override
    protected CharacteristicVo createVo() {
        return createDefault();
    }

    @Override
    protected CharacteristicRestService getRestService(RootResource proxy) {
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
    protected void prepareData(RootResource proxy) {
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

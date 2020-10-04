package com.library.server.integration;

import com.library.rest.api.service.FormatSignatureRestService;
import com.library.rest.api.vo.book.signature.FormatSignatureVo;
import com.library.rest.api.vo.list.FormatSignaturesListVo;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author gdimitrova
 */
public class IntegrationFormatSignatureRestServiceTest
        extends IntegrationAbstractCrudRestServiceTest<FormatSignatureVo, FormatSignaturesListVo, FormatSignatureRestService> {

    public IntegrationFormatSignatureRestServiceTest() {
        super(FormatSignatureVo.class, FormatSignaturesListVo.class);
    }

    @Override
    protected FormatSignatureVo createVo() {
        return createDefault();
    }

    @Override
    protected FormatSignatureRestService getRestService() {
        return proxy.getFormatSignaturesRestService();
    }

    @Override
    protected FormatSignaturesListVo createListVo() {
        return createFormatSignatures();
    }

    @Override
    protected void assertVos(FormatSignatureVo expected, FormatSignatureVo actual, boolean isSaveAction) {
        if (!isSaveAction) {
            assertEquals(expected, actual);
            return;
        }
        assertEquals(expected.getName(), actual.getName());
    }

    @Override
    protected void prepareData() {
    }

    private static FormatSignatureVo createVo(String abbr, String name) {
        return new FormatSignatureVo(abbr, name);
    }

    public static FormatSignatureVo createDefault() {
        return createVo("A", "Book pocket format");
    }

    public static FormatSignaturesListVo createFormatSignatures() {
        List<FormatSignatureVo> stockSignatures = new ArrayList<>();
        stockSignatures.add(createVo("M", "Magazines"));
        stockSignatures.add(createVo("G", "Graphics"));
        return new FormatSignaturesListVo(stockSignatures);
    }

}

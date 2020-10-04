package com.library.server.integration;

import com.library.rest.api.service.StockSignatureRestService;
import com.library.rest.api.vo.book.signature.StockSignatureVo;
import com.library.rest.api.vo.list.StockSignaturesListVo;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author gdimitrova
 */
public class IntegrationStockSignatureRestServiceTest
        extends IntegrationAbstractCrudRestServiceTest<StockSignatureVo, StockSignaturesListVo, StockSignatureRestService> {

    public IntegrationStockSignatureRestServiceTest() {
        super(StockSignatureVo.class, StockSignaturesListVo.class);
    }

    @Override
    protected StockSignatureVo createVo() {
        return createDefault();
    }

    @Override
    protected StockSignatureRestService getRestService() {
        return proxy.getStockSignaturesRestService();
    }

    @Override
    protected StockSignaturesListVo createListVo() {
        return createStockSignatures();
    }

    @Override
    protected void assertVos(StockSignatureVo expected, StockSignatureVo actual, boolean isSaveAction) {
        if (!isSaveAction) {
            assertEquals(expected, actual);
            return;
        }
        assertEquals(expected.getName(), actual.getName());
    }

    @Override
    protected void prepareData() {
    }

    private static StockSignatureVo createVo(String abbr, String name) {
        return new StockSignatureVo(abbr, name);
    }

    public static StockSignatureVo createDefault() {
        return createVo("Ch", "Child stock");
    }

    public static StockSignaturesListVo createStockSignatures() {
        List<StockSignatureVo> stockSignatures = new ArrayList<>();
        stockSignatures.add(createVo("FR", "French readroom"));
        stockSignatures.add(createVo("AR", "American readroom"));
        return new StockSignaturesListVo(stockSignatures);
    }

}

/*
 * Project library
 */
package com.library.persistence;

import com.library.dao.DaoRegistry;
import com.library.dao.book.StockSignatureDaoImpl;
import com.library.domain.book.signature.StockSignature;
import com.library.dto.StockSignatureDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class StockSignatureDaoTestCase extends AbstractCrudDaoTestCase<StockSignatureDto, StockSignature, StockSignatureDaoImpl> {

    @Override
    protected StockSignature createEntity() {
        return createDefault();
    }

    @Override
    protected List<StockSignature> createEntities() {
        return createStockSignatures();
    }

    @Override
    protected StockSignatureDaoImpl getDao(DaoRegistry registry) {
        return (StockSignatureDaoImpl) registry.getStockSignatureDao();
    }

    private static StockSignature createEntity(String abbr,String name) {
        return new StockSignature(abbr,name);
    }

    public static StockSignature createDefault() {
        return createEntity("Ch","Child stock");
    }

    public static List<StockSignature> createStockSignatures() {
        List<StockSignature> stockSignatures = new ArrayList<>();
        stockSignatures.add(createEntity("FR","French readroom"));
        stockSignatures.add(createEntity("AR","American readroom"));
        return stockSignatures;
    }

    @Override
    protected void prepareDbData(DaoRegistry registry) {
    }

    @Override
    protected boolean isRequiredDbDataPreparation() {
        return false;
    }
}

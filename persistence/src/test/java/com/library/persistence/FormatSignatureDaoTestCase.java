/*
 * Project library
 */
package com.library.persistence;

import com.library.dao.DaoRegistry;
import com.library.dao.book.FormatSignatureDaoImpl;
import com.library.domain.book.signature.FormatSignature;
import com.library.dto.FormatSignatureDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class FormatSignatureDaoTestCase extends AbstractCrudDaoTestCase<FormatSignatureDto, FormatSignature, FormatSignatureDaoImpl> {

    @Override
    protected FormatSignature createEntity() {
        return createDefault();
    }

    @Override
    protected List<FormatSignature> createEntities() {
        return createFormatSignatures();
    }

    @Override
    protected FormatSignatureDaoImpl getDao(DaoRegistry registry) {
        return (FormatSignatureDaoImpl) registry.getFormatSignatureDao();
    }

    private static FormatSignature createEntity(String abbr, String name) {
        return new FormatSignature(abbr, name);
    }

    public static FormatSignature createDefault() {
        return createEntity("A", "Book pocket format");
    }

    public static List<FormatSignature> createFormatSignatures() {
        List<FormatSignature> stockSignatures = new ArrayList<>();
        stockSignatures.add(createEntity("M", "Magazines"));
        stockSignatures.add(createEntity("G", "Graphics"));
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

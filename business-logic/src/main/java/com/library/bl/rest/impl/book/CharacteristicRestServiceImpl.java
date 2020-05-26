package com.library.bl.rest.impl.book;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.dao.CharacteristicDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.book.Characteristic;
import com.library.rest.api.book.CharacteristicRestService;
import com.library.rest.api.request.CharacteristicRequest;
import com.library.rest.api.request.CharacteristicsRequest;
import java.util.Set;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class CharacteristicRestServiceImpl  extends AbstractRestService<CharacteristicDao, Characteristic> implements CharacteristicRestService {

    public CharacteristicRestServiceImpl(DaoRegistryFactory factory) {
        super(factory);
    }

   
    @Override
    protected CharacteristicDao getDao(DaoRegistry registry) {
        return registry.getCharacteristicDao();
    }

    @Override
    public Response save(CharacteristicRequest request) {
        return this.save(request.getEntity());
    }

    @Override
    public Response update(CharacteristicRequest request) {
        return this.update(request.getEntity());
    }

    @Override
    public Response load(Long id) {
        return this.loadById(id);
    }

    @Override
    public Response saveAll(CharacteristicsRequest request) {
        return this.saveAll(request.getList());
    }

    @Override
    public Response deleteAll(CharacteristicsRequest request) {
        return this.deleteAll(request.getList());
    }

    @Override
    protected Set<String> validate(Characteristic entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

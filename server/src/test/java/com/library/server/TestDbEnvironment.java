/*
 * EuroRisk Systems (c) Ltd. All rights reserved.
 */
package com.library.server;

import com.library.rest.api.CrudRestService;
import com.library.rest.api.RootResource;
import com.library.rest.api.vo.AbstractVo;
import com.library.rest.api.vo.EntityListVo;
import com.library.rest.api.vo.list.AuthorsListVo;
import com.library.rest.api.vo.list.BookSeriesListVo;
import com.library.rest.api.vo.list.BooksListVo;
import com.library.rest.api.vo.list.BooksRentalListVo;
import com.library.rest.api.vo.list.CharacteristicsListVo;
import com.library.rest.api.vo.list.GenresListVo;
import com.library.rest.api.vo.list.PublishersListVo;
import com.library.rest.api.vo.list.UsersListVo;
import com.library.rest.api.vo.list.WorkFormsListVo;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class TestDbEnvironment {

    private final RootResource proxy;

    public TestDbEnvironment(RootResource proxy) {
        this.proxy = proxy;
    }

    public void removeData() {
        removeData(proxy.getBooksRentalsRestService(), BooksRentalListVo.class);
        removeData(proxy.getBooksRestService(), BooksListVo.class);
        removeData(proxy.getAuthorsRestService(), AuthorsListVo.class);
        removeData(proxy.getBookSeriesRestService(), BookSeriesListVo.class);
        removeData(proxy.getCharacteristicsRestService(), CharacteristicsListVo.class);
        removeData(proxy.getGenresRestService(), GenresListVo.class);
        removeData(proxy.getPublishersRestService(), PublishersListVo.class);
        removeData(proxy.getUsersRestService(), UsersListVo.class);
        removeData(proxy.getWorkformsRestService(), WorkFormsListVo.class);
    }

    private <Vo extends AbstractVo, ListVo extends EntityListVo<Vo>> void removeData(CrudRestService<Vo, ListVo> restService, Class<ListVo> clazz) {
        Response rsp = restService.loadAll();
        ListVo list = (ListVo) rsp.readEntity(clazz);
        rsp.close();
        rsp = restService.deleteAll(list);
        rsp.close();
    }

}

package com.library.server;

import com.library.bl.rest.impl.book.AuthorRestServiceImpl;
import com.library.bl.rest.impl.book.BookRentalRestServiceImpl;
import com.library.bl.rest.impl.book.BookRestServiceImpl;
import com.library.bl.rest.impl.book.BookSerieRestServiceImpl;
import com.library.bl.rest.impl.book.CharacteristicRestServiceImpl;
import com.library.bl.rest.impl.book.GenreRestServiceImpl;
import com.library.bl.rest.impl.book.PublisherRestServiceImpl;
import com.library.bl.rest.impl.book.WorkFormRestServiceImpl;
import com.library.bl.rest.impl.user.UserRestServiceImpl;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.DaoRegistryFactoryImpl;
import com.library.dao.EntityManagerFactoryHolder;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 *
 * @author gdimitrova
 */
@ApplicationPath("/")
public class RestApplication extends Application {

    private final Set<Object> beans = new HashSet<>();

    private final DaoRegistryFactory factory;

    public RestApplication() {
        factory = new DaoRegistryFactoryImpl(EntityManagerFactoryHolder.INSTANCE);
        beans.add(new JacksonJsonProvider());
        addServices();
    }

    @Override
    public Set<Object> getSingletons() {
        return beans;
    }

    private void addServices() {
        beans.add(new AuthorRestServiceImpl(factory));
        beans.add(new BookRentalRestServiceImpl(factory));
        beans.add(new BookRestServiceImpl(factory));
        beans.add(new BookSerieRestServiceImpl(factory));
        beans.add(new CharacteristicRestServiceImpl(factory));
        beans.add(new GenreRestServiceImpl(factory));
        beans.add(new PublisherRestServiceImpl(factory));
        beans.add(new WorkFormRestServiceImpl(factory));
        beans.add(new UserRestServiceImpl(factory));
    }
}

package com.library.server;

import com.library.bl.rest.impl.book.BookRestServiceImpl;
import com.library.bl.rest.impl.user.UserRestServiceImpl;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryImpl;
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

    private final DaoRegistry registry;

    public RestApplication() {
        registry = new DaoRegistryImpl();
        beans.add(new JacksonJsonProvider());
        addServices();
    }

    @Override
    public Set<Object> getSingletons() {
        return beans;
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        beans.forEach((s) -> {
            classes.add(s.getClass());
        });
        return classes;
    }

    private void addServices() {
        beans.add(new UserRestServiceImpl(registry));
        beans.add(new BookRestServiceImpl(registry));
        // To do
    }
}

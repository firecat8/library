package com.library.server;

import com.library.bl.rest.impl.RootResourceImpl;
import com.library.bl.rest.impl.SecurityFilter;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.DaoRegistryFactoryImpl;
import com.library.dao.EntityManagerFactoryHolder;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 *
 * @author gdimitrova
 */
@ApplicationPath("/")
public class RestApplication extends Application {

    private final Set<Object> beans = new LinkedHashSet<>();

    private final DaoRegistryFactory factory;

    public RestApplication() {
        this(EntityManagerFactoryHolder.INSTANCE);
        beans.add(new SecurityFilter(factory));
    }

    public RestApplication(EntityManagerFactory emf) {
        factory = new DaoRegistryFactoryImpl(emf);
        beans.add(new JacksonJsonProvider());
        beans.add(new RootResourceImpl(factory));
    }

    @Override
    public Set<Object> getSingletons() {
        return beans;
    }

}

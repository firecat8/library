package com.library.server;

import com.library.bl.rest.impl.SecurityFilter;
import com.library.rest.api.CrudRestService;
import com.library.rest.api.RootResource;
import com.library.rest.api.vo.AbstractVo;
import com.library.rest.api.vo.EntityListVo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static junit.framework.TestCase.assertEquals;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 *
 * @author gdimitrova
 * @param <Vo>
 * @param <ListVo>
 * @param <RestService>
 */
@RunWith(JUnit4.class)
public abstract class IntegrationAbstractCrudRestServiceTest<
        Vo extends AbstractVo, ListVo extends EntityListVo<Vo>, RestService extends CrudRestService<Vo, ListVo>> {

    private final static Logger LOGGER = Logger.getLogger(IntegrationAbstractCrudRestServiceTest.class.getName());

    protected final static String SERVER_URI = "http://localhost:8000/";

    private static ResteasyClient createClient() {
        ResteasyClientBuilderImpl builder = new ResteasyClientBuilderImpl();
        builder.getProviderFactory().register(JacksonJsonProvider.class);
        return builder.build();
    }

    private static RootResource createProxy() {
        ResteasyWebTarget target = client.target(SERVER_URI);
        return target.proxyBuilder(RootResource.class)
                .defaultConsumes(MediaType.APPLICATION_JSON)
                .defaultProduces(MediaType.APPLICATION_JSON)
                .build();
    }

    private static ResteasyClient client;

    protected final RootResource proxy = createProxy();

    private final TestDbEnvironment dbEnvironment = new TestDbEnvironment(proxy);

    private static ServerApplication SERVER_APP;

    private final Class<Vo> voClass;

    private final Class<ListVo> listVoClass;

    public IntegrationAbstractCrudRestServiceTest(Class<Vo> voClass, Class<ListVo> listVoClass) {
        this.voClass = voClass;
        this.listVoClass = listVoClass;
    }

    @BeforeClass
    public static void beforeAll() {
        try {
            SERVER_APP = new ServerApplication(createFactory());
            SERVER_APP.startServer();
            client = createClient();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }

    }

    private static EntityManagerFactory createFactory() {
        return Persistence.createEntityManagerFactory("com.library");
    }

    @AfterClass
    public static void afterAll() {
        try {
            SERVER_APP.stopServer();
            SERVER_APP.close();
            client.close();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }

    @Before
    public void beforeEach() {
        prepareData();
    }

    @After
    public void afterEach() {
        dbEnvironment.removeData();
    }

    abstract protected RestService getRestService();

    abstract protected Vo createVo();

    abstract protected void assertVos(Vo expected, Vo actual, boolean isSaveAction);

    abstract protected ListVo createListVo();

    abstract protected void prepareData();

    @Test
    public void testSave() {
        Vo vo = createVo();
        RestService restService = getRestService();
        Response rsp = restService.save(vo);
        assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
        assertVos(vo, (Vo) rsp.readEntity(voClass), true);
        rsp.close();
    }

    @Test
    public void testLoadById() {
        Vo vo = createVo();
        RestService restService = getRestService();
        Response saveRsp = restService.save(vo);
        Vo saved = (Vo) saveRsp.readEntity(voClass);
        saveRsp.close();
        Response rsp = restService.loadById(saved.getId());
        assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
        assertVos(saved, (Vo) rsp.readEntity(voClass), false);
        rsp.close();
    }

    @Test
    public void testLoadNotValidId() {
        RestService restService = getRestService();
        Response rsp = restService.loadById(123L);
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), rsp.getStatus());
        rsp.close();
    }

    @Test
    public void testDelete() {
        Vo vo = createVo();
        RestService restService = getRestService();
        Response saveRsp = restService.save(vo);
        Vo saved = (Vo) saveRsp.readEntity(voClass);
        saveRsp.close();
        restService.delete(saved.getId());
        Response rsp = restService.loadById(saved.getId());
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), rsp.getStatus());
        rsp.close();
    }

    @Test
    public void testSaveAll() {
        ListVo createListVo = createListVo();
        RestService restService = getRestService();
        Response rsp = restService.saveAll(createListVo);
        assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
        rsp.close();
    }

    @Test
    public void testLoadAll() {
        ListVo createListVo = createListVo();
        RestService restService = getRestService();
        Response rsp = restService.saveAll(createListVo);
        assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
        rsp.close();
        rsp = restService.loadAll();
        assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
        ListVo actual = rsp.readEntity(listVoClass);
        rsp.close();
        assertLists(createListVo, actual);
    }

    @Test
    public void testDeleteAll() {
        ListVo createListVo = createListVo();
        RestService restService = getRestService();
        Response rsp = restService.saveAll(createListVo);
        assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
        rsp.close();
        rsp = restService.loadAll();
        assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
        ListVo loaded = rsp.readEntity(listVoClass);
        rsp.close();
        rsp = restService.deleteAll(loaded);
        assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
        rsp.close();
        rsp = restService.loadAll();
        assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
        ListVo actual = rsp.readEntity(listVoClass);
        rsp.close();
        assertEquals(0, actual.getEntities().size());
    }

    private void assertLists(ListVo exList, ListVo acList) {
        List<Vo> expected = exList.getEntities();
        List<Vo> actual = acList.getEntities();
        for (int i = 0; i < expected.size(); i++) {
            assertVos(expected.get(i), actual.get(i), true);
        }
    }

}

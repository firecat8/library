package com.library.server.stress;

import com.library.rest.api.CrudRestService;
import com.library.rest.api.RootResource;
import com.library.rest.api.vo.AbstractVo;
import com.library.rest.api.vo.EntityListVo;
import com.library.server.ServerApplication;
import com.library.server.TestDbEnvironment;
import java.util.ArrayList;
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
public abstract class StressAbstractCrudRestServiceTest<
        Vo extends AbstractVo, ListVo extends EntityListVo<Vo>, RestService extends CrudRestService<Vo, ListVo>> {

    private final static Logger LOGGER = Logger.getLogger(StressAbstractCrudRestServiceTest.class.getName());

    protected final static Integer MAX_COUNT = 50;

    protected final static String SERVER_URI = "http://localhost:8000/";

    private static RootResource createProxy(ResteasyClient client) {
        ResteasyWebTarget target = client.target(SERVER_URI);
        return target.proxyBuilder(RootResource.class)
                .defaultConsumes(MediaType.APPLICATION_JSON)
                .defaultProduces(MediaType.APPLICATION_JSON)
                .build();
    }

    private static final List<ResteasyClient> CLIENTS = new ArrayList<>();

    protected static final List<RootResource> PROXIES = new ArrayList<>();

    private static ServerApplication SERVER_APP;

    private final Class<Vo> voClass;

    private final Class<ListVo> listVoClass;

    public StressAbstractCrudRestServiceTest(Class<Vo> voClass, Class<ListVo> listVoClass) {
        this.voClass = voClass;
        this.listVoClass = listVoClass;
    }

    @BeforeClass
    public static void beforeAll() {
        try {
            SERVER_APP = new ServerApplication(createFactory());
            SERVER_APP.startServer();
            ResteasyClientBuilderImpl builder = new ResteasyClientBuilderImpl();
            builder.getProviderFactory().register(JacksonJsonProvider.class);
            for (int i = 0; i < MAX_COUNT; i++) {
                ResteasyClient client = builder.build();
                RootResource proxy = createProxy(client);
                CLIENTS.add(client);
                PROXIES.add(proxy);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        LOGGER.log(Level.SEVERE, " beforeAll");

    }

    private static EntityManagerFactory createFactory() {
        return Persistence.createEntityManagerFactory("com.library");
    }

    @AfterClass
    public static void afterAll() {
        try {
            SERVER_APP.stopServer();
            SERVER_APP.close();
            for (int i = 0; i < MAX_COUNT; i++) {
                CLIENTS.get(i).close();
            }
            CLIENTS.clear();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        LOGGER.log(Level.SEVERE, " afterAll");
    }

    @Before
    public void beforeEach() {
        prepareData(PROXIES.get(0));
        LOGGER.log(Level.SEVERE, "{0} beforeEach", voClass.getName());
    }

    @After
    public void afterEach() {
        new TestDbEnvironment(PROXIES.get(0)).removeData();
        LOGGER.log(Level.SEVERE, "{0} afterEach", voClass.getName());
    }

    abstract protected RestService getRestService(RootResource proxy);

    abstract protected Vo createVo();

    abstract protected void assertVos(Vo expected, Vo actual, boolean isSaveAction);

    abstract protected ListVo createListVo();

    abstract protected void prepareData(RootResource proxy);

    private void log(int i, String msg) {
        LOGGER.log(Level.INFO, "{0}Client i={1}: {2}", new Object[]{voClass.getName(), i, msg});
    }

    @Test
    public void testSave() {
        for (int i = 0; i < MAX_COUNT; i++) {
            log(i, "testSave");
            Vo vo = createVo();
            RestService restService = getRestService(PROXIES.get(i));
            Response rsp = restService.save(vo);
            assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
            assertVos(vo, (Vo) rsp.readEntity(voClass), true);
            rsp.close();
        }
    }

    @Test
    public void testLoadById() {
        for (int i = 0; i < MAX_COUNT; i++) {
            log(i, "testLoadById");
            Vo vo = createVo();
            RestService restService = getRestService(PROXIES.get(i));
            Response saveRsp = restService.save(vo);
            Vo saved = (Vo) saveRsp.readEntity(voClass);
            saveRsp.close();
            Response rsp = restService.loadById(saved.getId());
            assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
            assertVos(saved, (Vo) rsp.readEntity(voClass), false);
            rsp.close();
        }
    }

    @Test
    public void testLoadNotValidId() {
        for (int i = 0; i < MAX_COUNT; i++) {
            log(i, "testLoadNotValidId");
            RestService restService = getRestService(PROXIES.get(i));
            Response rsp = restService.loadById(123L);
            assertEquals(Response.Status.NOT_FOUND.getStatusCode(), rsp.getStatus());
            rsp.close();
        }
    }

    @Test
    public void testDelete() {
        for (int i = 0; i < MAX_COUNT; i++) {
            log(i, "testDelete");
            Vo vo = createVo();
            RestService restService = getRestService(PROXIES.get(i));
            Response saveRsp = restService.save(vo);
            Vo saved = (Vo) saveRsp.readEntity(voClass);
            saveRsp.close();
            restService.delete(saved.getId());
            Response rsp = restService.loadById(saved.getId());
            assertEquals(Response.Status.NOT_FOUND.getStatusCode(), rsp.getStatus());
            rsp.close();
        }
    }

    @Test
    public void testSaveAll() {
        for (int i = 0; i < MAX_COUNT; i++) {
            log(i, "testSaveAll");
            ListVo createListVo = createListVo();
            RestService restService = getRestService(PROXIES.get(i));
            Response rsp = restService.saveAll(createListVo);
            assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
            rsp.close();
        }
    }

    @Test
    public void testLoadAll() {
        for (int i = 0; i < MAX_COUNT; i++) {
            log(i, "testLoadAll");
            ListVo createListVo = createListVo();
            RestService restService = getRestService(PROXIES.get(i));
            Response rsp = restService.saveAll(createListVo);
            assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
            rsp.close();
            rsp = restService.loadAll();
            assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
            ListVo actual = rsp.readEntity(listVoClass);
            rsp.close();
            assertLists(createListVo, actual);
        }
    }

    @Test
    public void testDeleteAll() {
        for (int i = 0; i < MAX_COUNT; i++) {
            log(i, "testDeleteAll");
            ListVo createListVo = createListVo();
            RestService restService = getRestService(PROXIES.get(i));
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
    }

    private void assertLists(ListVo exList, ListVo acList) {
        List<Vo> expected = exList.getEntities();
        List<Vo> actual = acList.getEntities();
        for (int i = 0; i < expected.size(); i++) {
            assertVos(expected.get(i), actual.get(i), true);
        }
    }

}

package com.library.server.integration;

import com.library.rest.api.service.UserRestService;
import com.library.rest.api.vo.DateVo;
import com.library.rest.api.vo.list.UsersListVo;
import com.library.rest.api.vo.user.RolesVo;
import com.library.rest.api.vo.user.UserVo;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ws.rs.core.Response;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

/**
 *
 * @author gdimitrova
 */
public class IntegrationUserRestServiceTest
        extends IntegrationAbstractCrudRestServiceTest<UserVo, UsersListVo, UserRestService> {

    public IntegrationUserRestServiceTest() {
        super(UserVo.class, UsersListVo.class);
    }

    @Override
    protected UserVo createVo() {
        return createDefault();
    }

    @Override
    protected UserRestService getRestService() {
        return proxy.getUsersRestService();
    }

    @Override
    protected UsersListVo createListVo() {
        return createUsers();
    }

    @Override
    protected void assertVos(UserVo expected, UserVo actual, boolean isSaveAction) {
        assertUsers(expected, actual, isSaveAction);
    }

    @Override
    protected void prepareData() {
    }

    public static void assertUsers(UserVo expected, UserVo actual, boolean isSaveAction) {
        if (!isSaveAction) {
            assertEquals(expected, actual);
            return;
        }
        assertEquals(expected.getCreatedDate(), actual.getCreatedDate());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getSurname(), actual.getSurname());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getUserName(), actual.getUserName());
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
        assertEquals(expected.getRole(), actual.getRole());

    }

    private static UserVo createVo(String name, RolesVo role, String phoneNumber) {
        return new UserVo(name + "1234", "pass", name + "@avb.bg", role, name, name, name, phoneNumber, new DateVo(new GregorianCalendar(2020, 1, 1)));
    }

    public static UserVo createDefault() {
        return createVo("anton", RolesVo.READER, "5865163");
    }

    public static UsersListVo createUsers() {
        List<UserVo> users = new ArrayList<>();
        users.add(createVo("admin", RolesVo.ADMINISTRATOR, "89645"));
        users.add(createVo("ann", RolesVo.OPERATOR, "963158"));
        return new UsersListVo(users);
    }

    @Test
    public void testSave() {
        UserVo vo = createVo();
        UserRestService usersRestService = proxy.getUsersRestService();
        Response rsp = usersRestService.save(vo);
        assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
        rsp.close();
        rsp = usersRestService.load(vo.getUserName());
        assertEquals(Response.Status.OK.getStatusCode(), rsp.getStatus());
        rsp.close();
    }

}

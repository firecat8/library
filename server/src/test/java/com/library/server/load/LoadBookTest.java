package com.library.server.load;

import com.library.server.integration.IntegrationBookRestServiceTest;
import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.domain.TestMappings;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeMultiLoadRunner;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 *
 * @author gdimitrova
 */
@Ignore
@LoadWith("load_config.properties")
@TestMappings({
    @TestMapping(testClass = IntegrationBookRestServiceTest.class, testMethod = "testSave"),
    @TestMapping(testClass = IntegrationBookRestServiceTest.class, testMethod = "testSaveAll"),
    @TestMapping(testClass = IntegrationBookRestServiceTest.class, testMethod = "testDelete"),
    @TestMapping(testClass = IntegrationBookRestServiceTest.class, testMethod = "testDeleteAll"),
    @TestMapping(testClass = IntegrationBookRestServiceTest.class, testMethod = "testLoadById")
})
@RunWith(ZeroCodeMultiLoadRunner.class)
public class LoadBookTest {

}

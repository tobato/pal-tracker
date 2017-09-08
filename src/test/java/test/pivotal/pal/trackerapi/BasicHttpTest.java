package test.pivotal.pal.trackerapi;

import io.pivotal.pal.tracker.PalTrackerApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * @author wuyf
 * @create 2017-09-08 下午12:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PalTrackerApplication.class, webEnvironment = RANDOM_PORT)
public abstract class BasicHttpTest {

    @LocalServerPort
    protected String port;
    @Autowired
    protected TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        RestTemplateBuilder builder = new RestTemplateBuilder()
                .rootUri("http://localhost:" + port)
                .basicAuthorization("user", "password");

        restTemplate = new TestRestTemplate(builder);
    }
}

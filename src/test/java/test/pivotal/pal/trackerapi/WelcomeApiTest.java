package test.pivotal.pal.trackerapi;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WelcomeApiTest extends BasicHttpTest{

    @Test
    public void exampleTest() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).isEqualTo("Hello from test");
    }
}

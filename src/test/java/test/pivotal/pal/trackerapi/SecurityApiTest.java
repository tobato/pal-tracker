package test.pivotal.pal.trackerapi;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class SecurityApiTest extends BasicHttpTest{

    private TestRestTemplate authorizedRestTemplate;

    @Autowired
    private TestRestTemplate unAuthorizedRestTemplate;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        authorizedRestTemplate = this.restTemplate;
    }

    @Test
    public void unauthorizedTest() {
        ResponseEntity<String> response = this.unAuthorizedRestTemplate.getForEntity("/", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void authorizedTest() {
        ResponseEntity<String> response = this.authorizedRestTemplate.getForEntity("/", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}

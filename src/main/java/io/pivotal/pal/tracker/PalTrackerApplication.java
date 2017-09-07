package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author wuyf
 * @create 2017-09-04 下午4:41
 */
@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    TimeEntryRepository timeEntryRepository() {
        return new JdbcTimeEntryRepository(jdbcTemplate.getDataSource());
    }
}

package io.swit.ctsmonitor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CtsMonitorApplicationTests {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:environment.yml,"
            + "classpath:application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(CtsMonitorApplicationTests.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }
}

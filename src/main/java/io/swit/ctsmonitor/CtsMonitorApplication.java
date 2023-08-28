package io.swit.ctsmonitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableAdminServer
public class CtsMonitorApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:environment.yml,"
            + "classpath:application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(CtsMonitorApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }
}

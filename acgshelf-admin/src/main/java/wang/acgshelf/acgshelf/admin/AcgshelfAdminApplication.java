package wang.acgshelf.acgshelf.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class AcgshelfAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcgshelfAdminApplication.class, args);
    }

}


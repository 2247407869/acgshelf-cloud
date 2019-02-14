package wang.acgshelf.acgshelf.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AcgshelfServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcgshelfServiceAdminApplication.class, args);
    }

}


package wang.acgshelf.acgshelf.service.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AcgshelfServiceRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcgshelfServiceRedisApplication.class, args);
    }

}

package wang.acgshelf.acgshelf.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class AcgshelfZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcgshelfZipkinApplication.class, args);
    }

}


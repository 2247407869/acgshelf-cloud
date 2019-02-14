package wang.acgshelf.acgshelf.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "wang.acgshelf.acgshelf.service.admin.mapper")
public class AcgshelfServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcgshelfServiceAdminApplication.class, args);
    }

}


package wang.acgshelf.acgshelf.service.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
@MapperScan(basePackages = "wang.acgshelf.acgshelf.service.sso.mapper")
public class AcgshelfServiceSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcgshelfServiceSsoApplication.class, args);
    }

}

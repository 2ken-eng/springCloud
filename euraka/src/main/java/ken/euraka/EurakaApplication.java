package ken.euraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author changtao
 */
@SpringBootApplication

/**
 *
 * 开启注册中心
 */
@EnableEurekaServer
public class EurakaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurakaApplication.class, args);
    }

}

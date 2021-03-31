package ken.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By C on 2021-03-23
 * @author changtao
 */


@RestController
/**
 *
 *
 *
 */
public class HelloController {



    @Value("${server.port}")
    Integer port;

    @GetMapping("/hello")
    public String hello(){

        return "hello" + port;
    }


}

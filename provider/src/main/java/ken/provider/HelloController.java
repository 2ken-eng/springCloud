package ken.provider;

import ken.commons.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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




    @GetMapping("/restGet")

    public String hello2(String name,String sex){


        return "name="+name+"/sex="+sex;
    }



    @PostMapping("/restPost")
    public User addUser1(User user){

        return user;
    }


    @PostMapping("/restPost2")
    public User addUser2(@RequestBody User user){

        return user;
    }








}

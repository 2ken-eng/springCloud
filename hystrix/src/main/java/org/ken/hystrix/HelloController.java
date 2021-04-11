package org.ken.hystrix;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Create By C on 2021-04-09
 */


@RestController
public class HelloController {



    @Autowired
    HelloService helloService;



    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/hello")
    public String hello(){

        return helloService.hello();


    }






    @GetMapping("/hello2")
    public void hello2(){


        HelloCommand helloCommand1 = new HelloCommand(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ken")),restTemplate);


        String execute = helloCommand1.execute();

        System.out.println(execute);





    }




}

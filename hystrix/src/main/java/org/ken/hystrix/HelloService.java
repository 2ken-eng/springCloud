package org.ken.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Create By C on 2021-04-09
 */


@Service
public class HelloService {



    @Autowired
    RestTemplate restTemplate;


    /**
     *
     *
     * 熔断 服务出错时候访问 error方法
     *
     *
     * @return
     */
    @HystrixCommand(defaultFallback = "error")
    public String hello(){


       return  restTemplate.getForObject("http://provider/hello",String.class);


    }



    public String error(){


        return "error!";
    }
}

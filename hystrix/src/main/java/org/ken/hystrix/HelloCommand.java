package org.ken.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * Create By C on 2021-04-09
 */
public class HelloCommand extends HystrixCommand<String> {



    RestTemplate restTemplate;

    public HelloCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {
        return restTemplate.getForObject("http://provider/hello",String.class);
    }


    //服务失败调动这个方法
    @Override
    protected String getFallback() {
        return super.getFallback();
    }
}

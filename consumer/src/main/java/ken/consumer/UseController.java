package ken.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * Create By C on 2021-03-23
 */

@RestController
/**
 *
 *
 *
 */
public class UseController {


    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    @Qualifier("restTemplateOne")
    RestTemplate restTemplateOne;




    @GetMapping("/consumer")

//http://ken:1114/consumer
    public String hello2(){


        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider");

        ServiceInstance serviceInstance = instanceList.get(0);

        String host = serviceInstance.getHost();

        int port = serviceInstance.getPort();

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("http://")
                .append(host)
                .append(":")
                .append(port)
                .append("/hello");



        System.out.println(stringBuffer.toString());


        String s1 = restTemplateOne.getForObject(stringBuffer.toString(), String.class);

        return s1;


/*        HttpURLConnection httpURLConnection = null;


        try {
            URL uRl = new URL(stringBuffer.toString());


            httpURLConnection = (HttpURLConnection) uRl.openConnection();

            if (httpURLConnection.getResponseCode() == 200){

                BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                String s = br.readLine();
                return s;
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       return "error";*/
    }

    @Autowired
    @Qualifier("restTemplate")
    RestTemplate restTemplate;



    @GetMapping("/consumer2")
    public String hello3(){


        return restTemplate.getForObject("http://provider/hello",String.class);
    }
}

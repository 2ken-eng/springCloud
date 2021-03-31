package ken.consumer;


import ken.commons.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
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






    @GetMapping("/consumer/getobj")

    public String hello4(String name) throws UnsupportedEncodingException {


        String s1 = restTemplate.getForObject("http://provider/restGet?name={1}",String.class,name);


        System.out.println(s1);
//        return  s1;


        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://provider/restGet?name={1}", String.class, name);


        String body = forEntity.getBody();
        System.out.println(body);


        HttpStatus statusCode = forEntity.getStatusCode();

        System.out.println(statusCode);


        HttpHeaders headers = forEntity.getHeaders();

        System.out.println(headers);


        int statusCodeValue = forEntity.getStatusCodeValue();

        System.out.println(statusCodeValue);


        //********************************Map方式传参


        HashMap<String, String> map = new HashMap<>();


        map.put("name", URLEncoder.encode("江山一点红", "UTF-8"));
        map.put("sex",URLEncoder.encode("男", "UTF-8"));


        String s2 = restTemplate.getForObject("http://provider/restGet?name={name}&sex={sex}", String.class, map);
        System.out.println("s2="+s2);


        System.out.println(URLDecoder.decode(s2,"UTF-8"));


        return  s2;


    }



    @GetMapping("/postKey")
    public User hello5(){


        MultiValueMap<String, Object> valueMap = new LinkedMultiValueMap<>();


//        以KEY VALUE 形式传参
        valueMap.add("UserNmae","王五");
        valueMap.add("UserPassword","12345");
        valueMap.add("id",99001);

        User user = restTemplate.postForObject("http://provider/restPost",valueMap, User.class);


        System.out.println(user);

//以Json对象传参



        user.setUserNmae("Test02");


        User user1 = restTemplate.postForObject("http://provider/restPost2", user, User.class);


        System.out.println(user1);


        return user1;


    }




    @GetMapping("/postLocation")

    public String hello8() throws UnsupportedEncodingException {

        MultiValueMap<String,Object> map = new LinkedMultiValueMap<>();
        map.add("UserNmae",URLEncoder.encode("张三","UTF-8"));
        map.add("id",99001);


        URI uri = restTemplate.postForLocation("http://provider/reg", map, User.class);


        System.out.println(uri);


        String s = restTemplate.getForObject(uri, String.class);


//        System.out.println(URLDecoder.decode(s,"UTF-8"));

        return s;


    }





































}

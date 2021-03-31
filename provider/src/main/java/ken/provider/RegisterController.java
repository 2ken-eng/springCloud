package ken.provider;

import ken.commons.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create By C on 2021-03-31
 * @author changtao
 */


@Controller
public class RegisterController {





    @PostMapping("/reg")

    public String register(User user){


        System.out.println(user.getUserNmae());
        //返回重定向地址
        return "redirect:http://provider/loginPage?username="+user.getUserNmae();
    }



    @GetMapping("/loginPage")

    @ResponseBody

    public String loginPage(String username){
        return "loginPage:"+ username;
    }








}

package app.qienuren.templatecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLoginView(){
        return "login";
    }

    @GetMapping("inlogsucces")
    public String getSuccesLogin(){
        return "inlogsucces";
   }

    @GetMapping("admin")
    public String getAdminPage(){
       return "admin";
    }

    @GetMapping("trainee")
    public String getTraineePage(){
        return "trainee";
    }
}
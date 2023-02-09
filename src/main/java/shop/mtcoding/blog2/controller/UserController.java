package shop.mtcoding.blog2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    
    @GetMapping("/update")
    public String userUpdate(){
        
    return "user/updateForm";
    }

    @GetMapping("/login")
    public String userLogin(){
        
    return "user/loginForm";
    }

    @GetMapping("/join")
    public String userJoin(){
        
    return "user/joinForm";
    }

    @GetMapping("/logout")
    public String logout(){
        
    return "redirect:/";
    }

}

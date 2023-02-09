package shop.mtcoding.blog2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog2.dto.user.UserReq.UserJoinDto;

@Controller
public class UserController {
    
    @GetMapping("/update")
    public String updateForm(){
        
    return "user/updateForm";
    }

    @GetMapping("/login")
    public String loginForm(){
        
    return "user/loginForm";
    }

    @GetMapping("/join")
    public String joinForm(){
        
    return "user/joinForm";
    }

    @GetMapping("/logout")
    public String logout(){
        
    return "redirect:/";
    }

    @PostMapping("/join")
    public String userJoin(UserJoinDto userDto){
        if( userDto.getUsername()==null||userDto.getUsername().isEmpty()){
            return "";
        }
        if( userDto.getPassword()==null||userDto.getPassword().isEmpty()){
            return "";
        }
        if( userDto.getEmail()==null||userDto.getEmail().isEmpty()){
            return "";
        }
        
        return "redirect:/";
    }

    @PostMapping("/join")
    public String userJoin1(){
        
        return "";
    }

    @PostMapping("/join")
    public String userJoin2(){
        
        return "";
    }

    @PostMapping("/join")
    public String userJoin3(){
        
        return "";
    }

}

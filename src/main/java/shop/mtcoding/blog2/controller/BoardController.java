package shop.mtcoding.blog2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @GetMapping("/")
    public String  main(){
        
    return "board/main";
    }

    @GetMapping("/board/write")
    public String boardWrite(){
        
    return "board/writeForm";
    }

    @GetMapping("/1")
    public String  main2(){
        
    return "board/main";
    }

    @GetMapping("/2")
    public String  main3(){
        
    return "board/main";
    }

    @GetMapping("/3")
    public String  main4(){
        
    return "board/main";
    }

}

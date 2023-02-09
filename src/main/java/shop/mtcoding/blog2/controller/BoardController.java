package shop.mtcoding.blog2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog2.dto.board.BoardReq.BoardWriteDto;
import shop.mtcoding.blog2.dto.board.BoardResp.BoardMainListDto;
import shop.mtcoding.blog2.exception.CustomException;
import shop.mtcoding.blog2.model.BoardRepository;
import shop.mtcoding.blog2.model.User;
import shop.mtcoding.blog2.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private HttpSession session;

    @Autowired
    private BoardService service;
    
    @Autowired
    private BoardRepository boardRepository;

    private void mockSession(){
        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setUsername("ssar");
        mockUser.setPassword("1234");
        mockUser.setEmail("ssar@nate.com");
        session.setAttribute("principal", mockUser);
    }

    @GetMapping("/")
    public String  main(Model model){
        mockSession();
    List<BoardMainListDto> dtos = boardRepository.findAllforList();
    model.addAttribute("dtos", dtos);
    return "board/main";
    }

    @GetMapping("/board/write")
    public String writeForm(){
        
    return "board/writeForm";
    }

    @GetMapping("/1")
    public String  main2(){
        
    return "board/main";
    }

    @PostMapping("/board/write")
    public String boardWrite(BoardWriteDto boardDto){
        User principal = (User) session.getAttribute("principal");
        if( principal == null ){
            throw new CustomException("로그인이 필요한 기능입니다.");
        }
        if( boardDto.getTitle()==null||boardDto.getTitle().isEmpty()){
            throw new CustomException("글 제목이 없습니다.");
        }
        if( boardDto.getTitle().length()>100){
            throw new CustomException("제목을 100자 이내로 작성하세요.");
        }        
        if( boardDto.getContent()==null||boardDto.getContent().isEmpty()){
            throw new CustomException("글 내용이 없습니다.");
        }
        service.글쓰기(boardDto, principal.getId());
        return "board/main";
    }

    @GetMapping("/3")
    public String  main4(){
        
    return "board/main";
    }

    

}

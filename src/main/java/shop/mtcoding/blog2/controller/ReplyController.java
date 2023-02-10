package shop.mtcoding.blog2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog2.dto.reply.ReplyReq.ReplySaveReqDto;
import shop.mtcoding.blog2.exception.CustomException;
import shop.mtcoding.blog2.model.User;
import shop.mtcoding.blog2.service.ReplyService;

@Controller
public class ReplyController {
    
    @Autowired
    private HttpSession session;

    @Autowired
    private ReplyService replyService;

    @PostMapping("/reply")
    public String save(ReplySaveReqDto rdto){
        User principal = (User) session.getAttribute("principal");
        if( principal ==null){
            throw new CustomException("인증이 되지 않았습니다.",HttpStatus.UNAUTHORIZED);
        }
        if( rdto.getComment()==null||rdto.getComment().isEmpty()){
            throw new CustomException("댓글을 작성해주세요");
        }
        
        if( rdto.getBoardId() == null){ // null 을 걸러야 함.. INTEGER 로 선언해
            throw new CustomException("게시글 번호가 필요합니다.");
        }
        
        replyService.댓글쓰기(rdto, principal.getId());

        return "redirect:/board/detail/"+rdto.getBoardId();
    }
}

package shop.mtcoding.blog2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog2.dto.ResponseDto;
import shop.mtcoding.blog2.dto.reply.ReplyReq.ReplySaveReqDto;
import shop.mtcoding.blog2.exception.CustomApiException;
import shop.mtcoding.blog2.exception.CustomException;
import shop.mtcoding.blog2.model.Reply;
import shop.mtcoding.blog2.model.ReplyRepository;
import shop.mtcoding.blog2.model.User;
import shop.mtcoding.blog2.service.ReplyService;

@Controller
public class ReplyController {
    
    @Autowired
    private HttpSession session;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private ReplyRepository replyRepository;

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

    @DeleteMapping("/reply/{id}")
    public ResponseEntity<?> deleteReply(@PathVariable int id){
        User principal = (User) session.getAttribute("principal");
        if( principal == null){
            throw new CustomApiException("인증이 되지 않았습니다.",HttpStatus.UNAUTHORIZED);
        }
        Reply reply = replyRepository.findById(id);
        if ( reply == null ){
            throw new CustomApiException("게시글에 작성된 댓글만 삭제할 수 있습니다.");
        }
        if ( reply.getUserId() != principal.getId()){
            throw new CustomApiException("자신이 작성한 댓글만 삭제할 수 있습니다.", HttpStatus.FORBIDDEN);
        }
        replyService.댓글삭제();
        
        return new ResponseEntity<>(new ResponseDto<>(1, "삭제 성공", null), HttpStatus.OK);
    }
}

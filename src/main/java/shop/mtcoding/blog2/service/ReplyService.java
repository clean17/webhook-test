package shop.mtcoding.blog2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog2.dto.reply.ReplyReq.ReplySaveReqDto;
import shop.mtcoding.blog2.exception.CustomException;
import shop.mtcoding.blog2.model.ReplyRepository;

@Service
public class ReplyService {
    
    @Autowired
    private ReplyRepository replyRepository;

    @Transactional
    public void 댓글쓰기(ReplySaveReqDto rDto, int principalId){
        int result = replyRepository.insert(
                rDto.getComment(),
                rDto.getBoardId(),
                principalId
                );
        if ( result != 1 ){
            throw new CustomException("댓글 쓰기 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void 댓글삭제() {
    }

    // @Transactional
    // public void 댓글삭제(int id, int principalId){
    //     Board board = replyRepository.findById(id);
    //     if ( board == null ){
    //         throw new CustomApiException("해당 게시글이 없습니다.");
    //     }
    //     Board board2 = replyRepository.findById(id);
    //     if ( board2.getUserId() != principalId){
    //         throw new CustomApiException("삭제할 권한이 없습니다.", HttpStatus.FORBIDDEN);
    //     }
    //     int result1 = replyRepository.delete(id);
    //     if ( result1 != 1 ){
    //         throw new CustomApiException("서버에 일시적인 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @Transactional
    // public void 댓글수정(BoardUpdateDto bDto, int id,  int principalId){

    //     String thumbnail = HtmlParser.thumbnailString(bDto.getContent());

    //     Board board = replyRepository.findById(id);
    //     if ( board == null ){
    //         throw new CustomApiException("해당 게시글이 없습니다.");
    //     }
    //     Board board2 = replyRepository.findById(id);
    //     if ( board2.getUserId() != principalId){
    //         throw new CustomApiException("수정할 권한이 없습니다.", HttpStatus.FORBIDDEN);
    //     }
    //     int result1 = replyRepository.update(
    //                         bDto.getTitle(),
    //                         bDto.getContent(),
    //                         thumbnail,
    //                         id);
    //     if ( result1 != 1 ){
    //         throw new CustomApiException("서버에 일시적인 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
}

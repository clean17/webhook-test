package shop.mtcoding.blog2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog2.dto.board.BoardReq.BoardWriteDto;
import shop.mtcoding.blog2.exception.CustomApiException;
import shop.mtcoding.blog2.exception.CustomException;
import shop.mtcoding.blog2.model.Board;
import shop.mtcoding.blog2.model.BoardRepository;

@Service
public class BoardService {
    
    @Autowired
    private BoardRepository boardRepository;
    @Transactional
    public void 글쓰기(BoardWriteDto bDto, int principalId){
        int result = boardRepository.insertBoard(bDto.getTitle(), bDto.getContent(), principalId);
        if ( result != 1 ){
            throw new CustomException("글 쓰기에 실패 했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public void 글삭제(int id, int principalId){
        int result = boardRepository.deleteBoard(principalId);
        if ( result != 1 ){
            throw new CustomApiException("해당 게시글이 없습니다.");
        }
        Board board = boardRepository.findById(id);
        if ( board.getUserId() != principalId){
            throw new CustomApiException("삭제할 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }
        int result1 = boardRepository.deleteBoard(id);
        if ( result1 != 1 ){
            throw new CustomApiException("서버에 일시적인 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package shop.mtcoding.blog2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog2.dto.board.BoardReq.BoardWriteDto;
import shop.mtcoding.blog2.exception.CustomException;
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
}

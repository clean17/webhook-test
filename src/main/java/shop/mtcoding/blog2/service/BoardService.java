package shop.mtcoding.blog2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog2.dto.board.BoardReq.BoardWriteDto;

@Service
public class BoardService {
    
    @Transactional
    public void 글쓰기(BoardWriteDto bDto, int principalId){
        
    }
}

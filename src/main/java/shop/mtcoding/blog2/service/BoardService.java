package shop.mtcoding.blog2.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog2.Util.HtmlParser;
import shop.mtcoding.blog2.dto.board.BoardReq.BoardUpdateDto;
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
        
        String thumbnail = HtmlParser.thumbnailString(bDto.getContent());
        int result = boardRepository.insertBoard(
                        bDto.getTitle(), 
                        bDto.getContent(),
                        thumbnail,
                        principalId);
        if ( result != 1 ){
            throw new CustomException("글 쓰기에 실패 했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public void 글삭제(int id, int principalId){
        Board board = boardRepository.findById(id);
        if ( board == null ){
            throw new CustomApiException("해당 게시글이 없습니다.");
        }
        Board board2 = boardRepository.findById(id);
        if ( board2.getUserId() != principalId){
            throw new CustomApiException("삭제할 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }
        int result1 = boardRepository.deleteBoard(id);
        if ( result1 != 1 ){
            throw new CustomApiException("서버에 일시적인 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public void 글수정(BoardUpdateDto bDto, int id,  int principalId){

        String thumbnail = HtmlParser.thumbnailString(bDto.getContent());

        Board board = boardRepository.findById(id);
        if ( board == null ){
            throw new CustomApiException("해당 게시글이 없습니다.");
        }
        Board board2 = boardRepository.findById(id);
        if ( board2.getUserId() != principalId){
            throw new CustomApiException("수정할 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }
        int result1 = boardRepository.updateBoard(
                            bDto.getTitle(),
                            bDto.getContent(),
                            thumbnail,
                            id);
        if ( result1 != 1 ){
            throw new CustomApiException("서버에 일시적인 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

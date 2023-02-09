package shop.mtcoding.blog2.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import shop.mtcoding.blog2.dto.board.BoardResp.BoardDetailDto;
import shop.mtcoding.blog2.dto.board.BoardResp.BoardMainListDto;
import shop.mtcoding.blog2.dto.board.BoardResp.BoardUpdateDto;

@Mapper
public interface BoardRepository {
    public List<Board> findAll();
    public Board findById(int id);
    public int insertBoard(
        @Param("title") String title,
        @Param("content") String content,
        @Param("userId") int userId
    );
    public List<BoardMainListDto> findAllforList();

    public BoardDetailDto findBoardforDetail(int id);
    public int deleteBoard(int id);
    public int updateBoard(
        @Param("title") String title,
        @Param("content") String content
    );
    public BoardUpdateDto findByIdforUpdate(int id);
}

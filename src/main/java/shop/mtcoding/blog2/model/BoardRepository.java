package shop.mtcoding.blog2.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardRepository {
    public List<Board> findAll();
    public int insertBoard(
        @Param("title") String title,
        @Param("content") String content,
        @Param("userId") int userId
    );
}

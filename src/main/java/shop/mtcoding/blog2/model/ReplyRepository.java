package shop.mtcoding.blog2.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReplyRepository {
    public List<Reply> findAll();
    public Board findById(int id);
    public int insertReply(
        @Param("comment") String comment,
        @Param("userId") int userId,
        @Param("boardId") int boardId
    );
    public int deleteReply(int id);
    public int updateReply(
        @Param("comment") String title,
        @Param("userId") int content
    );
}

package shop.mtcoding.blog2.dto.reply;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class ReplyResp {
    
    @Getter
    @Setter
    public static class ReplyListRespDto {
        private Integer id;
        private String comment;
        private String username;
        private int boardId;
        private Timestamp createdAt;
    }
}

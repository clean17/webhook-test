package shop.mtcoding.blog2.dto.board;

import lombok.Getter;
import lombok.Setter;

public class BoardResp {
    
    @Getter
    @Setter
    public static class BoardMainListDto{
        private int id;
        private String title;
        private String username;
    }

    @Getter
    @Setter
    public static class BoardDetailDto{
        private int id;
        private String title;
        private String content;
        private String username;
    }

    @Getter
    @Setter
    public static class BoardUpdateDto{
        private int id;
        private String title;
        private String content;
        private String username;
        private int userId;
    }
}

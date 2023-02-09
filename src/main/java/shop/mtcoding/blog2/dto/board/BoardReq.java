package shop.mtcoding.blog2.dto.board;

import lombok.Getter;
import lombok.Setter;

public class BoardReq {
    @Getter
    @Setter
    public static class BoardWriteDto{
        private String title;
        private String content;
    }
}

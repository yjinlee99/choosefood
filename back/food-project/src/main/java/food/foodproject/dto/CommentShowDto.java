package food.foodproject.dto;

import lombok.Data;

@Data
public class CommentShowDto {
    String user;
    String userImg;
    String content;

    public CommentShowDto() {}

    public CommentShowDto(String user, String userImg, String content) {
        this.user = user;
        this.userImg = userImg;
        this.content = content;
    }
}

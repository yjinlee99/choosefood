package food.foodproject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostShowAllDto {
    String title;
    String nickname;
    String profileImg;
    String thumbImg;
    int view;
    LocalDateTime uploadDate;

    public PostShowAllDto(String title, String nickname, String profileImg, String thumbImg, int view, LocalDateTime uploadDate) {
        this.title = title;
        this.nickname = nickname;
        this.profileImg = profileImg;
        this.thumbImg = thumbImg;
        this.view = view;
        this.uploadDate = uploadDate;
    }

}

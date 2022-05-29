package food.foodproject.dto;

import lombok.Data;

@Data
public class PostShowAllDto {
    String title;
    String nickname;
    String profileImg;
    String thumbImg;

    public PostShowAllDto(String title, String nickname, String profileImg, String thumbImg) {
        this.title = title;
        this.nickname = nickname;
        this.profileImg = profileImg;
        this.thumbImg = thumbImg;
    }

}

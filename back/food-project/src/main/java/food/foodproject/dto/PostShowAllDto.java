package food.foodproject.dto;

import lombok.Data;

@Data
public class PostShowAllDto {
    String title;
    String nickname;
    String img;

    public PostShowAllDto(String title, String nickname, String img) {
        this.title = title;
        this.nickname = nickname;
        this.img = img;
    }

}

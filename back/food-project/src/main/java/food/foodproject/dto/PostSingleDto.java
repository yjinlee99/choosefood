package food.foodproject.dto;

import food.foodproject.domain.Member;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostSingleDto {

    private Long id;
    private String title;
    private LocalDateTime uploadDate;
    private String introduce;
    private String thumbImg;
    private String ingredient;
    private String recipe;
    private String stepImg;
    private int view;
    private String memberImg;

    public PostSingleDto() {};

    public PostSingleDto(Long id, String title, LocalDateTime uploadDate, String introduce, String thumbImg, String ingredient, String recipe, String stepImg, int view, String memberImg) {
        this.id = id;
        this.title = title;
        this.uploadDate = uploadDate;
        this.introduce = introduce;
        this.thumbImg = thumbImg;
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.stepImg = stepImg;
        this.view = view;
        this.memberImg = memberImg;
    }
}

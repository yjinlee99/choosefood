package food.foodproject.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class FoodResultDto {
    List<FoodDto> posts;
    boolean isLast;

    public FoodResultDto() {}

    public FoodResultDto(List<FoodDto> posts, boolean isLast) {
        this.posts = posts;
        this.isLast = isLast;
    }
}

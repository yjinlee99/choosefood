package food.foodproject.dto;

import com.querydsl.core.annotations.QueryProjection;
import food.foodproject.domain.Food;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class FoodDto {
    private String name;
    private String intro;
    private String ingredient;
    private String recipe;
    private String theme;
    private String taste;
    private String situation;
    private String thumbnail;
    private String stepImg;

    @SneakyThrows
    @QueryProjection
    public FoodDto(Food food){
        this.name = food.getName();
        this.intro = food.getIntro();
        this.ingredient = food.getIngredient();
        this.recipe = food.getRecipe();
        this.theme = food.getTheme();
        this.taste = food.getTaste();
        this.situation = food.getSituation();
        this.thumbnail = food.getThumbnail();
        this.stepImg = food.getStepImg();
    }
}
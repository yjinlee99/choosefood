package food.foodproject.dto;

import com.querydsl.core.annotations.QueryProjection;
import food.foodproject.domain.Food;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class FoodDto {
    private String name;
    private String ingredients;
    private String recipe;
    private String theme;
    private String cook;
    private String taste;
    private String situation;
    private String img;

    @SneakyThrows
    @QueryProjection
    public FoodDto(Food food){
        this.name = food.getName();
        this.ingredients = food.getIngredients();
        this.recipe = food.getRecipe();
        this.theme = food.getTheme();
        this.cook = food.getCook();
        this.taste = food.getTaste();
        this.situation = food.getSituation();
        this.img = food.getImg();
    }
}

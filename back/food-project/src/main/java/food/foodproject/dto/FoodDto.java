package food.foodproject.dto;

import food.foodproject.domain.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FoodDto {
    private String name;
    private String ingredients;
    private String theme;
    private String cook;
    private String taste;
    private String situation;

    public FoodDto(Food entity){
        this.name = entity.getName();
        this.ingredients = entity.getIngredients();
        this.theme = entity.getTheme();
        this.cook = entity.getCook();
        this.taste = entity.getTaste();
        this.situation = entity.getSituation();
    }

    public void setFoodDto(String ) {

    }
}

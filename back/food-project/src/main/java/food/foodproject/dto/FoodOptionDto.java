package food.foodproject.dto;

import lombok.*;

import java.util.List;

@Data
public class FoodOptionDto {

    private List<String> theme;
    private List<String> taste;
    private List<String> ingredients;
    private List<String> situations;

    public FoodOptionDto(List<String> theme,  List<String> taste, List<String> ingredients, List<String> situations) {

        this.theme = theme;
        this.taste = taste;
        this.ingredients = ingredients;
        this.situations = situations;
    }
}

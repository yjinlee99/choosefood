package food.foodproject.dto;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Data
@Setter
public class FoodOptionDto {

    private List<String> theme;
    private List<String> taste;
    private List<String> ingredients;
    private List<String> situations;
    private String refrigerator;

    public FoodOptionDto(List<String> theme,  List<String> taste, List<String> ingredients, List<String> situations, String refrigerator) {

        this.theme = theme;
        this.taste = taste;
        this.ingredients = ingredients;
        this.situations = situations;
        this.refrigerator = refrigerator;
    }

}

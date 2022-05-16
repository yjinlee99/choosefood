package food.foodproject.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class FoodOptionDto {
    private ArrayList<String> ingredients;
    private ArrayList<String> theme;
    private ArrayList<String> cook;
    private ArrayList<String> taste;
    private ArrayList<String> situation;

    public void setIngredients(String ingredients) {
        this.ingredients = new ArrayList<>(Arrays.asList(ingredients.split(" ")));
    }

    public void setTheme(String theme) {
        this.theme = new ArrayList<>(Arrays.asList(theme.split(" ")));
    }

    public void setCook(String cook) {
        this.cook = new ArrayList<>(Arrays.asList(cook.split(" ")));
    }

    public void setTaste(String taste) {
        this.taste = new ArrayList<>(Arrays.asList(taste.split(" ")));
    }

    public void setSituation(String situation) {
        this.situation = new ArrayList<>(Arrays.asList(situation.split(" ")));
    }


}

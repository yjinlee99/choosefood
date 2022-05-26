package food.foodproject.dto;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class SingleFoodDto {
    private String food;

    public SingleFoodDto() {

    }

    public SingleFoodDto(String food) {
        this.food = food;
    }
}

package food.foodproject.dto;

import com.querydsl.core.annotations.QueryProjection;
import food.foodproject.domain.Food;
import lombok.*;

@Getter
@Setter
@Data
public class FoodDto {
    private String name;
    private String thumbnail;

    public FoodDto() {}

    public FoodDto(String name, String thumbnail){
        this.name = name;
        this.thumbnail = thumbnail;
    }
}
package food.foodproject.repository;

import food.foodproject.domain.Food;
import java.util.List;

public interface FoodRepositoryCustom {
    List<Food> findBySearchOption(List<String> themes, List<String> tastes, List<String> ingredients, List<String> situations);
}

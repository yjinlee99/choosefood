package food.foodproject.repository;

import food.foodproject.domain.Food;
import food.foodproject.dto.FoodDto;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.dto.FoodSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FoodRepositoryCustom {
    List<Food> findBySearchRefigerator(List<String> ingredients);
    List<Food> findBySearchOption(List<String> themes, List<String> tastes, List<String> ingredients, List<String> situations);
}
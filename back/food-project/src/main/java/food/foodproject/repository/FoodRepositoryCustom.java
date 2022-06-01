package food.foodproject.repository;

import food.foodproject.dto.FoodDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepositoryCustom {
    List<FoodDto> findBySearchRefrigerator(List<String> ingredients, int start, int limit);
    List<FoodDto> findBySearchOption(List<String> themes, List<String> tastes, List<String> ingredients, List<String> situations, int start, int limit);
    public List<FoodDto> findBySearch(String str);
}
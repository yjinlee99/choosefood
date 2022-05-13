package food.foodproject.repository;

import food.foodproject.domain.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FoodRepositoryCustom {
    Page<Food> findBySearchOption(Pageable pageable, String name, String ingredients, String recipe,
                                 String theme, String cook, String taste, String situation, String img);
}

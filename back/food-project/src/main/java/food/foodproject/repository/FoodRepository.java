package food.foodproject.repository;

import food.foodproject.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>, FoodRepositoryCustom {
    Food findByName(String name);
    List<Food> findByNameContains(String name);
}
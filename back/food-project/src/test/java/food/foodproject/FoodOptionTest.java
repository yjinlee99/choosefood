package food.foodproject;

import food.foodproject.domain.Food;
import food.foodproject.dto.FoodDto;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.repository.FoodRepository;
import food.foodproject.repository.FoodRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FoodOptionTest {
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    FoodRepositoryImpl foodRepositorylmpl;

    @Test
    void contextLoads() {
        Food food1 = new Food();

        food1.setName("사과");
        food1.setTheme("매콤");

        Food newFood = foodRepository.save(food1);

        Food food2 = new Food();

        food2.setName("배");
        food2.setTheme("달콤");

        Food newFood2 = foodRepository.save(food2);

        FoodOptionDto condition = new FoodOptionDto();
        condition.setTheme("매콤");

        List<FoodDto> results = foodRepositorylmpl.findBySearchOption(condition);}
}

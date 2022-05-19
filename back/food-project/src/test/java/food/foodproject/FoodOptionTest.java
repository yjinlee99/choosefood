package food.foodproject;

import food.foodproject.domain.Food;
import food.foodproject.dto.FoodDto;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.repository.FoodRepository;
import food.foodproject.repository.FoodRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Transactional
public class FoodOptionTest {
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    FoodRepositoryImpl foodRepositorylmpl;

    @Test
    void contextLoads() {
        String[] names = {"쭈꾸미", "배", "사과", "고기"};
        String[] tastes = {"매콤", "달콤", "고소", "짭짤"};
        String[] theme = {"테마"};
        String[] ingredients = {"쭈꾸미", "사과", "닭", "돼지"};
        String[] situations = {"간식", "식사", "후식", "야식"};

        List<Long> foodIdxs = new ArrayList<>();
        for(int i=0; i<names.length; i++) {
            Food food = new Food();
            food.setName(names[i]);
            food.setTaste(tastes[i]);
            food.setTheme(theme[0]);
            food.setIngredient(ingredients[i]);
            food.setSituation(situations[i]);
            foodRepository.save(food);
        }

        for(int i=0; i<5; i++) {
            Food food = new Food();
            food.setName(names[0]+i+"입니다.");
            food.setTaste(tastes[0]);
            food.setTheme(theme[0]);
            food.setIngredient(ingredients[0]);
            food.setSituation(situations[0]);
            foodRepository.save(food);
        }

        FoodOptionDto condition = new FoodOptionDto(Arrays.asList(theme), Arrays.asList(tastes), Arrays.asList("과일", "고기"), Arrays.asList(situations));
        

        System.out.println("---------------- 원하는 음식 검색2 ------------- ");
        List<Food> foodsInSearch2 = foodRepositorylmpl.findBySearchOption(condition.getTheme(), condition.getTaste(), condition.getIngredients(), condition.getSituations());
        for(Food food : foodsInSearch2) {
            System.out.println(food.getId() + " " + food.getName() + " " + food.getTheme() + " " +food.getTaste() +" "+ food.getIngredient() + " " + food.getSituation());
        }
    }
}

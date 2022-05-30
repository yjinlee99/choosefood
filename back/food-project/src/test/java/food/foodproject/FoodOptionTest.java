package food.foodproject;

import SQL.DAO;
import SQL.DTO;
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
public class FoodOptionTest {
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    FoodRepositoryImpl foodRepositorylmpl;

    String[] names, intros, tastes, theme, ingredients, situations, recipe, thumbnail, stepImg;
    @Test
    void contextLoads() {


        ArrayList<DTO> dtos = DAO.getFoods();
        names = new String[dtos.size()];
        intros = new String[dtos.size()];
        tastes = new String[dtos.size()];
        theme = new String[dtos.size()];
        ingredients = new String[dtos.size()];
        situations = new String[dtos.size()];
        recipe = new String[dtos.size()];
        thumbnail = new String[dtos.size()];
        stepImg = new String[dtos.size()];
        for(int i=0;i<dtos.size();i++) {
            DTO dto = dtos.get(i);
            names[i] = dto.getTitle();
            intros[i] = dto.getIntro();
            tastes[i] = dto.getTaste();
            theme[i] = dto.getThema();
            ingredients[i] = dto.getIngredient();
            situations[i] = dto.getSituation();
            recipe[i] = dto.getStep();
            thumbnail[i] = dto.getThumbnail();
            stepImg[i] = dto.getStepimg();
        }
        List<Long> foodIdxs = new ArrayList<>();
        for(int i=0; i<dtos.size(); i++) {
            Food food = new Food();
            food.setName(names[i]);
            food.setIntro(intros[i]);
            food.setTaste(tastes[i]);
            food.setTheme(theme[i]);
            food.setIngredient(ingredients[i]);
            food.setSituation(situations[i]);
            food.setRecipe(recipe[i]);
            food.setThumbnail(thumbnail[i]);
            food.setStepImg(stepImg[i]);
            foodRepository.save(food);
        }


    }
}
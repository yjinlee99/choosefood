package food.foodproject.service;

import food.foodproject.domain.Food;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.repository.FoodRepository;
import food.foodproject.repository.FoodRepositoryCustom;
import food.foodproject.repository.FoodRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;


    public List<Food> selectOption(FoodOptionDto option){

        List<Food> foods = foodRepository.findBySearchOption(option.getTheme(),option.getTaste(),option.getIngredients(),option.getSituations());

        return foods;
    }
}
package food.foodproject.service;

import food.foodproject.domain.Food;
import food.foodproject.dto.FoodDto;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.dto.FoodRefDto;
import food.foodproject.dto.SingleFoodDto;
import food.foodproject.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public List<FoodDto> findFoodByOption(FoodOptionDto dto) {
        List<FoodDto> foods = foodRepository.findBySearchOption(dto.getTheme(), dto.getTaste(), dto.getIngredients(), dto.getSituations());

        return foods;
    }

    public Food findSingleFood(SingleFoodDto dto) {
        Food food = foodRepository.findByName(dto.getFood());
        System.out.println(food.getId());
        System.out.println(food);
        return food;
    }
    public List<FoodDto> findFoodByRef(List<String> refrigerator) {
        List<FoodDto> foods = foodRepository.findBySearchRefrigerator(refrigerator);
        return foods;
    }

    public List<FoodDto> findFoodBySearch(String str) {
        List<FoodDto> foods = foodRepository.findBySearch(str);

        return foods;
    }

}

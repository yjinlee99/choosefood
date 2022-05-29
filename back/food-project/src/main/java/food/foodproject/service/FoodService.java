package food.foodproject.service;

import food.foodproject.dto.FoodDto;
import food.foodproject.dto.FoodOptionDto;
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

}


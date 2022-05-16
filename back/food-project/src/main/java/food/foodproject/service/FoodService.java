package food.foodproject.service;

import food.foodproject.domain.Food;
import food.foodproject.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
}


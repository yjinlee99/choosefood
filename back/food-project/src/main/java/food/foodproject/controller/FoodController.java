package food.foodproject.controller;

import food.foodproject.domain.Food;
import food.foodproject.dto.FoodDto;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("/api/foodOption")
    public String foodOption(@RequestParam FoodOptionDto foodOptionDto){
        System.out.println(foodOptionDto);

        List<Food> foods = foodService.selectOption(foodOptionDto);

        if(foods.size()>0){
            return foodList(foods);
        }

        // return 리턴 데이터 반환
        return "Fail";
    }

    @PostMapping("/api/foodList")
    public String foodList(@RequestBody List<Food> foods){
        return foods;
    }

}

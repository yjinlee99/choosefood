package food.foodproject.controller;

import SQL.DAO;
import food.foodproject.domain.Food;
import food.foodproject.dto.FoodDto;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.dto.SingleFoodDto;
import food.foodproject.repository.FoodRepository;
import food.foodproject.repository.FoodRepositoryImpl;
import food.foodproject.service.FoodService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class FoodController {
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    private FoodService foodService;

    @PostMapping("/option")
    public List<FoodDto> option(@RequestBody FoodOptionDto dto) {
        System.out.println(dto);

        List<String> notnull = Arrays.asList("");
        if(dto.getTheme() == null) dto.setTheme(notnull);
        if(dto.getTaste() == null) dto.setTaste(notnull);
        if(dto.getSituations() == null) dto.setSituations(notnull);
        if(dto.getIngredients() == null) dto.setIngredients(notnull);
        if(dto.getRefrigerator() == null) dto.setRefrigerator("");

        System.out.println(dto.getIngredients());


        return foodService.findFoodByOption(dto);

    }

    @PostMapping("/singlefood")
    public Food singleFood(@RequestBody SingleFoodDto singleFoodDto) {
        Food food = foodRepository.findByName(singleFoodDto.getFood());
        System.out.println(food.getId());
        System.out.println(food);
        return food;
    }





//    @GetMapping("/dtos")
//    public List<FoodDto> getDtos(FoodOptionDto dto){
//
//
//    }

//    @GetMapping("/api/foodOption")
//    public String foodOption(@RequestParam FoodOptionDto foodOptionDto){
//        System.out.println(foodOptionDto);
//
//        List<Food> foods = foodService.selectOption(foodOptionDto);
//
//        if(foods.size()>0){
//            return foodList(foods);
//        }
//
//        // return 리턴 데이터 반환
//        return "Fail";
//    }
//
//    @PostMapping("/api/foodList")
//    public String foodList(@RequestBody List<Food> foods){
//        return "foods";
//    }

}
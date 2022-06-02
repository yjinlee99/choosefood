package food.foodproject.controller;

import SQL.DAO;
import food.foodproject.domain.Food;
import food.foodproject.dto.*;
import food.foodproject.repository.FoodRepository;
import food.foodproject.repository.FoodRepositoryImpl;
import food.foodproject.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @PostMapping("/option")
    public List<FoodDto> option(@RequestBody FoodOptionDto dto) {
        System.out.println(dto);

        List<String> notnull = Arrays.asList("");
        if(dto.getTheme() == null) dto.setTheme(notnull);
        if(dto.getTaste() == null) dto.setTaste(notnull);
        if(dto.getSituations() == null) dto.setSituations(notnull);
        if(dto.getIngredients() == null) dto.setIngredients(notnull);


        if(dto.getRefrigerator().contains("false")) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            List<FoodDto> foods = foodService.findFoodByOption(dto);
            FoodResultDto foodResultDto = new FoodResultDto(foods, false);
            return foods;
        }
        else {
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            List<FoodDto> foods = foodService.findFoodByRef(dto.getRefrigerator());
            FoodResultDto foodResultDto = new FoodResultDto(foods, false);
            return foods;
        }


    }

    @PostMapping("/singlefood")
    public Food singleFood(@RequestBody SingleFoodDto dto) {
        return foodService.findSingleFood(dto);
    }

    @GetMapping("/search")
    public List<FoodDto> search(@RequestParam String search) {
        return foodService.findFoodBySearch(search);
    }


}
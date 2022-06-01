package food.foodproject.controller;

import SQL.DAO;
import food.foodproject.domain.Food;
import food.foodproject.dto.FoodDto;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.dto.FoodRefDto;
import food.foodproject.dto.SingleFoodDto;
import food.foodproject.repository.FoodRepository;
import food.foodproject.repository.FoodRepositoryImpl;
import food.foodproject.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

        System.out.println(dto.getIngredients());

        if(dto.getRefrigerator().toString() == "") {
            dto.setRefrigerator(notnull);
            return foodService.findFoodByOption(dto);
        }
        else {
            return foodService.findFoodByRef(dto.getRefrigerator());
        }


    }

    @PostMapping("/singlefood")
    public Food singleFood(@RequestBody SingleFoodDto dto) {
        return foodService.findSingleFood(dto);
    }




}
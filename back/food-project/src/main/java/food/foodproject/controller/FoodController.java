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
    public List<FoodDto> option(@RequestBody FoodOptionDto dto, @RequestParam(defaultValue = "0") int start,
                                @RequestParam(defaultValue = "12") int limit) {
        System.out.println(dto);

        List<String> notnull = Arrays.asList("");
        if(dto.getTheme() == null) dto.setTheme(notnull);
        if(dto.getTaste() == null) dto.setTaste(notnull);
        if(dto.getSituations() == null) dto.setSituations(notnull);
        if(dto.getIngredients() == null) dto.setIngredients(notnull);


        if(StringUtils.hasText(dto.getRefrigerator().toString())) {
            dto.setRefrigerator(notnull);
            List<FoodDto> foods = foodService.findFoodByOption(dto, start, limit);
            FoodResultDto foodResultDto = new FoodResultDto(foods, false);
            return foods;
        }
        else {
            List<FoodDto> foods = foodService.findFoodByRef(dto.getRefrigerator(), start, limit);
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
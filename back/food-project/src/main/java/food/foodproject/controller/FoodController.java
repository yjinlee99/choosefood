package food.foodproject.controller;

import SQL.DAO;
import food.foodproject.domain.Food;
import food.foodproject.dto.FoodDto;
import food.foodproject.dto.FoodOptionDto;
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
    FoodRepositoryImpl foodRepositorylmpl;
    @Autowired
    FoodService foodService;

    static int cnt;
    String [] themeList;
    String [] tasteList;
    String [] ingredientList;
    String [] situationList;
    String [] refList;

    @PostMapping(value = "/option")
    public String option(@RequestBody String str) {
        cnt = 0;
        System.out.println(str);

        JSONObject jObject = new JSONObject(str);
        JSONArray theme = jObject.getJSONArray("theme");
        JSONArray taste = jObject.getJSONArray("taste");
        JSONArray ingredient = jObject.getJSONArray("ingredient");
        JSONArray situation = jObject.getJSONArray("situation");

        themeList = new String[theme.length()];
        tasteList = new String[taste.length()];
        ingredientList = new String[ingredient.length()];
        situationList = new String[situation.length()];

        for (int i = 0; i < theme.length(); ++i) {
            themeList[i] = theme.getString(i);
            System.out.println(themeList[i]);
        }
        for (int i = 0; i < taste.length(); ++i) {
            tasteList[i] = taste.getString(i);
            System.out.println(tasteList[i]);
        }
        for (int i = 0; i < ingredient.length(); ++i) {
            ingredientList[i] = ingredient.getString(i);
            System.out.println(ingredientList[i]);
        }
        for (int i = 0; i < situation.length(); ++i) {
            situationList[i] = situation.getString(i);
            System.out.println(situationList[i]);
        }

        return "text";
    }

    @PostMapping(value = "/ref")
    public String ref(@RequestBody String str) {
        cnt = 1;
        System.out.println(str);

        JSONObject jObject = new JSONObject(str);
        JSONArray refArr = jObject.getJSONArray("users");
        refList = new String[refArr.length()];

        for (int i = 0; i < refArr.length(); ++i) {
            JSONObject ref = refArr.getJSONObject(i);
            refList[i] = ref.getString("username");
            System.out.println(refList[i]);
        }

        return "text";
    }

    @GetMapping("/dtos")
    public List<Food> getDtos(){
        FoodOptionDto condition;
        List<Food> foodsInSearch2;
        if(cnt == 0) {
            condition = new FoodOptionDto(Arrays.asList(themeList), Arrays.asList(tasteList),
                    Arrays.asList(ingredientList), Arrays.asList(situationList));
            foodsInSearch2 = foodRepositorylmpl.findBySearchOption(condition.getTheme(),
                    condition.getTaste(), condition.getIngredients(), condition.getSituations());
        } else {
            condition = new FoodOptionDto(
                    Arrays.asList(""),
                    Arrays.asList(""),
                    Arrays.asList(refList),
                    Arrays.asList(""));
            foodsInSearch2 = foodRepositorylmpl.findBySearchRefigerator(condition.getIngredients());
        }
        return foodsInSearch2;
    }

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
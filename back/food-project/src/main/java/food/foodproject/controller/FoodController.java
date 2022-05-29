package food.foodproject.controller;

import SQL.DAO;
import food.foodproject.domain.Food;
import food.foodproject.dto.FoodDto;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.dto.SingleFoodDto;
import food.foodproject.dto.UserDto;
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
    String search;

    // 문자열 슬래시 공백 치환
    public static String deleteSlash(String name) {
        if (name.contains("/")) { // name 에 슬래시 포함되면 언더바로 치환
            name = name.replaceAll("/","");
        }
        return name;
    }

    // 레시피 옵션 저장
    @PostMapping(value = "/option")
    public void option(@RequestBody String str) {
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
            ingredientList[i] = deleteSlash(ingredient.getString(i));
            System.out.println(ingredientList[i]);
        }
        for (int i = 0; i < situation.length(); ++i) {
            situationList[i] = situation.getString(i);
            System.out.println(situationList[i]);
        }
    }

    // 냉장고 레시피 재료 저장
    @PostMapping(value = "/ref")
    public void ref(@RequestBody String str) {
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
    }

    // 냉장고 재료 수정
    @PostMapping(value = "/refUpdate")
    public void refUpdate(@RequestBody String str) {
        System.out.println(str);

        JSONObject jObject = new JSONObject(str);
        JSONArray refArr = jObject.getJSONArray("users");
        refList = new String[refArr.length()];

        for (int i = 0; i < refArr.length(); ++i) {
            JSONObject ref = refArr.getJSONObject(i);
            refList[i] = ref.getString("username");
            if(i == 0) {
                UserDto.ref = refList[i];
            } else {
                UserDto.ref = UserDto.ref + "," + refList[i];
            }
            System.out.println(refList[i]);
            System.out.println(UserDto.ref);
        }
        DAO.addRefValues(UserDto.ref, UserDto.email);
    }

    @PostMapping("/singleRecipe")
    public Food getSingleRecipe(@RequestBody String str) {
        System.out.println(str);
        JSONObject jObject = new JSONObject(str);
        Food food = foodRepository.findByName(jObject.getString("name"));
        System.out.println(food.getName());
        return food;
    }

    @PostMapping("/search")
    public void getSearch(@RequestBody String str) {
        cnt = 2;
        JSONObject jObject = new JSONObject(str);
        System.out.println(jObject.getString("search"));
        search = jObject.getString("search");
    }

    // 레시피 찾기
    @GetMapping("/dtos")
    public List<Food> getDtos(){
        FoodOptionDto condition;
        List<Food> foodsInSearch2;
        if(cnt == 0) {
            condition = new FoodOptionDto(Arrays.asList(themeList), Arrays.asList(tasteList),
                    Arrays.asList(ingredientList), Arrays.asList(situationList));
            foodsInSearch2 = foodRepositorylmpl.findBySearchOption(condition.getTheme(),
                    condition.getTaste(), condition.getIngredients(), condition.getSituations());
        } else if(cnt == 1) {
            condition = new FoodOptionDto(
                    Arrays.asList(""),
                    Arrays.asList(""),
                    Arrays.asList(refList),
                    Arrays.asList(""));
            foodsInSearch2 = foodRepositorylmpl.findBySearchRefigerator(condition.getIngredients());
        } else {
            foodsInSearch2 = foodRepository.findByNameContains(search);
        }
        return foodsInSearch2;
    }

}
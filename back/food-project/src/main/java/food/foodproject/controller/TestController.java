package food.foodproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import food.foodproject.domain.Food;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.repository.FoodRepository;
import food.foodproject.repository.FoodRepositoryImpl;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import SQL.DTO;
import SQL.DAO;
import SQL.ConnectionPool;

@RestController
public class TestController {
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    FoodRepositoryImpl foodRepositorylmpl;

//    ArrayList<DTO> dtos = DAO.getFoods();
//
//    String data = "_한식_중식 _매콤_짭짤 _고기_밥 _야식_해장";
//
//    ArrayList<DTO> dtosTest = DAO.getTestQuery(data); // 테마별

    @GetMapping("/home")
    public String getHome(){
        return "Hello World!";
    }

//    @GetMapping("/dtos")
//    public List<Food> getDtos(){
//        FoodOptionDto condition = new FoodOptionDto(Arrays.asList("한식","중식"),
//                Arrays.asList("매콤","짭짤"), Arrays.asList("고기","밥"), Arrays.asList("야식","해장"));
//        List<Food> foodsInSearch2 = foodRepositorylmpl.findBySearchOption(condition.getTheme(),
//                condition.getTaste(), condition.getIngredients(), condition.getSituations());
//        return foodsInSearch2;
//    }

    // application/json 으로 받을 때
    @PostMapping(value = "/test")
    public String test(@RequestBody String str) {
        System.out.println(str);

        JSONObject jObject = new JSONObject(str);
        String email = jObject.getString("email");
        String passwd = jObject.getString("passwd");

        System.out.println(email);
        System.out.println(passwd);

        return "text";
    }
}
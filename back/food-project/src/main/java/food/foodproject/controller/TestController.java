package food.foodproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

import SQL.DTO;
import SQL.DAO;
import SQL.ConnectionPool;

@RestController
public class TestController {

    ArrayList<DTO> dtos = DAO.getFoods();
//    String thema = "_한식_중식";
//    String taste = "_매콤_짭짤";
//    String ingredient = "_고기_밥";
//    String situation = "_야식_해장";
//
//    ArrayList<DTO> dtosTest1 = DAO.getThemaQuery(thema); // 테마별
//    ArrayList<DTO> dtosTest2 = DAO.getTasteQuery(taste); // 미각별
//    ArrayList<DTO> dtosTest3 = DAO.getIngredientQuery(ingredient); // 재료별
//    ArrayList<DTO> dtosTest4 = DAO.getSituationQuery(situation); // 상황별

    String data = "_한식_중식 _매콤_짭짤 _고기_밥 _야식_해장";

    ArrayList<DTO> dtosTest = DAO.getTestQuery(data); // 테마별

    @GetMapping("/home")
    public String getHome(){
        return "Hello World!";
    }
    @GetMapping("/thumbnail")
    public String getThumbnail(){
        DTO dto = dtos.get(0);
        return dto.getThumbnail();
    }
    @GetMapping("/title")
    public String getTitle(){
        DTO dto = dtos.get(1);
        return dto.getTitle();
    }
    @GetMapping("/dto")
    public DTO getDto(){
        DTO dto = dtos.get(0);
        return dto;
    }
    @GetMapping("/dtos")
    public ArrayList<DTO> getDtos(){
        return dtos;
    }

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
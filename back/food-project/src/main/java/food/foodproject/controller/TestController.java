package food.foodproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import SQL.DTO;
import SQL.DAO;

@RestController
public class TestController {
    ArrayList<DTO> dtos = DAO.getFoods();
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

        return "testIndex";
    }
}
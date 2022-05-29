package food.foodproject.controller;

import food.foodproject.domain.Food;
import food.foodproject.dto.FoodOptionDto;
import org.apache.catalina.User;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import food.foodproject.dto.UserDto;

@RestController
public class UserController {
    // 유저 정보 반환
    @GetMapping("/user")
    public String[] getUser(){
        String [] list = new String[5];
        list[0] = UserDto.email;
        list[1] = UserDto.passwd;
        list[2] = UserDto.name;
        list[3] = UserDto.phone;
        list[4] = UserDto.ref;
        return list;
    }

    // 냉장고 재료 반환
    @GetMapping("/userRef")
    public String[] getUserRef(){
        String [] list = UserDto.ref.split(",");
        JSONObject data = new JSONObject();
        String [] arr = new String[list.length];
        for(int i=1;i<=list.length;i++) {
            data.put("id", i);
            data.put("username", list[i-1]);
            System.out.println(data);
            arr[i-1] = data.toString();
        }
        return arr;
    }
}

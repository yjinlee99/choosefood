package food.foodproject.controller;

import SQL.DAO;
import SQL.DTO;
import food.foodproject.dto.UserDto;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    // 로그인 중복 체크
    @PostMapping(value = "/login")
    public Boolean login(@RequestBody String str) {
        System.out.println(str);

        JSONObject jObject = new JSONObject(str);
        String email = jObject.getString("email");
        String passwd = jObject.getString("passwd");

        System.out.println(email);
        System.out.println(passwd);

        if(DAO.checkLogin(email, passwd)) {
            DAO.getUserDto(email);
        }

        return DAO.checkLogin(email, passwd);
    }

    // 로그아웃
    @PostMapping(value = "/logout")
    public void logout(@RequestBody String str) {
        System.out.println(str);

        UserDto.email = "로그인 필요";
        UserDto.passwd = "";
        UserDto.name = "로그인이 필요합니다.";
        UserDto.phone = "***-****-****";
        UserDto.ref = "";
    }
}

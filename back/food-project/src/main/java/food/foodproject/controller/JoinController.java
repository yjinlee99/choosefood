package food.foodproject.controller;

import SQL.DAO;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {
    // application/json 으로 받을 때
    @PostMapping(value = "/join")
    public String join(@RequestBody String str) {
        System.out.println(str);

        JSONObject jObject = new JSONObject(str);
        String email = jObject.getString("email");
        String passwd = jObject.getString("passwd");
        String name = jObject.getString("name");
        String phone = jObject.getString("phone");
        System.out.println(email);
        System.out.println(passwd);
        System.out.println(name);
        System.out.println(phone);
        DAO.addUserValues(email, passwd, name, phone);
        return "text";
    }
}

package food.foodproject.controller;

import SQL.DAO;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {
    Boolean bool;

    // 회원가입 정보 DB 저장
    @PostMapping(value = "/join")
    public Boolean join(@RequestBody String str) {
        System.out.println(str);

        JSONObject jObject = new JSONObject(str);
        String email = jObject.getString("email");
        String name = jObject.getString("name");
        if(!DAO.checkJoin(email, name)) {
            String passwd = jObject.getString("passwd");
            String phone = jObject.getString("phone");
            System.out.println(email);
            System.out.println(passwd);
            System.out.println(name);
            System.out.println(phone);
            DAO.addUserValues(email, passwd, name, phone, "");

            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }
}

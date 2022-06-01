//package food.foodproject.controller;
//
//import SQL.DAO;
//import SQL.DTO;
//import org.json.JSONObject;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class LoginController {
//    String email;
//    String passwd;
//
//    // application/json 으로 받을 때
//    @PostMapping(value = "/login")
//    public String login(@RequestBody String str) {
//        System.out.println(str);
//
//        email = null;
//        passwd = null;
//
//        JSONObject jObject = new JSONObject(str);
//        email = jObject.getString("email");
//        passwd = jObject.getString("passwd");
//
//        System.out.println(email);
//        System.out.println(passwd);
//
//        return "text";
//    }
//
//    @GetMapping("/login")
//    public Boolean getLogin(){
//        System.out.println(DAO.checkLogin(email, passwd));
//        return DAO.checkLogin(email, passwd);
//    }
//}

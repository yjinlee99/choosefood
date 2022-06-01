//package food.foodproject.controller;
//
//import SQL.DAO;
//import org.json.JSONObject;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class JoinController {
//    String email;
//    String passwd;
//    Boolean bool;
//
//    // application/json 으로 받을 때
//    @PostMapping(value = "/join")
//    public String join(@RequestBody String str) {
//        System.out.println(str);
//
//        email = null;
//        passwd = null;
//
//            JSONObject jObject = new JSONObject(str);
//            email = jObject.getString("email");
//            passwd = jObject.getString("passwd");
//        if(!DAO.checkLogin(email, passwd)) {
//            String name = jObject.getString("name");
//            String phone = jObject.getString("phone");
//            System.out.println(email);
//            System.out.println(passwd);
//            System.out.println(name);
//            System.out.println(phone);
//            DAO.addUserValues(email, passwd, name, phone);
//            bool = false;
//        } else {
//            bool = true;
//        }
//        return "text";
//    }
//
//    @GetMapping("/join")
//    public Boolean getJoin(){
//        return bool;
//    }
//}

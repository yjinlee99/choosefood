package food.foodproject.controller;

import SQL.DAO;
import SQL.POSTS;
import food.foodproject.domain.Food;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.dto.UserDto;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PostController {
    static int cnt;
    String board;

    // 게시판 정보 DB 저장
    @PostMapping(value = "/post")
    public void getPost(@RequestBody String str) {
        cnt = 0;
        System.out.println(str);

        JSONObject jObject = new JSONObject(str);
        String name = jObject.getString("name");
        String intro = jObject.getString("intro");
        String ingredient = jObject.getString("ingredient");
        System.out.println(name);
        System.out.println(intro);
        System.out.println(ingredient);
        DAO.addPostValues(UserDto.email, name, intro, ingredient,
                "", "", "", "", 0);
    }

    @PostMapping("/singlePost")
    public ArrayList<POSTS> getSinglePost(@RequestBody String str) {
        System.out.println(str);
        JSONObject jObject = new JSONObject(str);
        String name = jObject.getString("name");
        ArrayList<POSTS> posts = DAO.getPost(name);
        return posts;
    }

    @PostMapping("/board")
    public void getBoard(@RequestBody String str) {
        cnt = 1;
        JSONObject jObject = new JSONObject(str);
        System.out.println(jObject.getString("board"));
        board = jObject.getString("board");
    }

    // 레시피 찾기
    @GetMapping("/posts")
    public ArrayList<POSTS> getPosts(){
        if(cnt == 0) {
            return DAO.getPosts();
        } else {
            cnt = 0;
            return DAO.getBoards(board);
        }
    }
}

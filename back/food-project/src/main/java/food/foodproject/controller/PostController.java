package food.foodproject.controller;

import food.foodproject.domain.Post;
import food.foodproject.dto.PostSaveDto;
import food.foodproject.dto.PostShowAllDto;
import food.foodproject.dto.PostSingleDto;
import food.foodproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    //게시물 저장
    @PostMapping("/post/save")
    public Long savePost(@RequestBody PostSaveDto postSaveDto) {
        return postService.save(postSaveDto);
    }

    //모든 게시물 보여주기
    @GetMapping("/posts")
    public List<PostShowAllDto> showPost(){
        return postService.findAll();
    }

    //게시물 하나 보여주기
    @GetMapping("/post/single")
    public PostSingleDto showSinglePost(@RequestParam String title) {
        return postService.findOne(title);
    }


    //내 게시물
    @PostMapping("/post/my")
    public List<PostShowAllDto> showMyPost(@RequestBody String id) {
        System.out.println(id);
        JSONObject jObject = new JSONObject(id);
        String Id = jObject.getString("id");
        return postService.findByUser(Long.parseLong(Id));
    }


}

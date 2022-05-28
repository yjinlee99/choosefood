package food.foodproject.controller;

import food.foodproject.domain.Post;
import food.foodproject.dto.PostSaveDto;
import food.foodproject.dto.PostShowAllDto;
import food.foodproject.dto.PostSingleDto;
import food.foodproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/savepost")
    public Long savePost(@RequestBody PostSaveDto postSaveDto) {
        return postService.save(postSaveDto);
    }

    @GetMapping("/posts")
    public List<PostShowAllDto> showPost(){
        return postService.findAll();
    }

    @PostMapping("/singlepost")
    public Post showSinglePost(@RequestBody PostSingleDto dto) {
        return postService.findOne(dto.getTitle());
    }

}

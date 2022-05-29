package food.foodproject.controller;

import food.foodproject.domain.Comment;
import food.foodproject.domain.Post;
import food.foodproject.dto.CommentSaveDto;
import food.foodproject.dto.CommentShowDto;
import food.foodproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/save")
    public Long saveComment(@RequestBody CommentSaveDto dto) {
        System.out.println(dto);
        return commentService.save(dto.getPostId(), dto.getUserId(), dto.getContent());
    }

    @GetMapping("/comment/show")
    public List<CommentShowDto> showPostComment(@RequestParam Long id) {

        List<CommentShowDto> comments = commentService.findByPostId(id);

        return comments;
    }

    @GetMapping("/comment/my")
    public List<CommentShowDto> showMyComment(@RequestParam Long id) {
        List<CommentShowDto> comments = commentService.findByUserId(id);

        return comments;
    }

}

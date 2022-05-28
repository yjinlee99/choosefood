package food.foodproject.controller;

import food.foodproject.domain.Comment;
import food.foodproject.domain.Post;
import food.foodproject.dto.CommentSaveDto;
import food.foodproject.dto.CommentShowDto;
import food.foodproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/comment/show")
    public List<Comment> showPostComment(@RequestBody CommentShowDto dto) {

        List<Comment> comments = commentService.findByPostId(dto.getId());

        return comments;
    }



}

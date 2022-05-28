package food.foodproject.dto;

import lombok.Data;

@Data
public class CommentSaveDto {
    private Long postId;
    private Long userId;
    private String content;
}

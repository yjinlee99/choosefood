package food.foodproject.dto;

import food.foodproject.domain.Member;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class PostSaveDto {
    private Long memberId;
    private String foodName;
    private String title;
    private String ingredient;
    private String recipe;
}

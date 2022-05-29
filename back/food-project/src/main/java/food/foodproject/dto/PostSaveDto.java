package food.foodproject.dto;

import food.foodproject.domain.Member;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class PostSaveDto {
    private Long memberId;
    private String title;
    private String introduce;
    private String thumbImg;
    private String ingredient;
    private String stepImg;
    private String recipe;
}

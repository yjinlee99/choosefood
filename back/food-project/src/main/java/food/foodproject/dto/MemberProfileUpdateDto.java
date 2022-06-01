package food.foodproject.dto;

import lombok.Data;

@Data
public class MemberProfileUpdateDto {
    private Long id;
    private String nickname;
    private String img;
}
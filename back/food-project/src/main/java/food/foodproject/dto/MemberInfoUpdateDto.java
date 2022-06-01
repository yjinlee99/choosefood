package food.foodproject.dto;

import lombok.Data;

@Data
public class MemberInfoUpdateDto {
    private Long id;
    private String phone;
    private String password;
}
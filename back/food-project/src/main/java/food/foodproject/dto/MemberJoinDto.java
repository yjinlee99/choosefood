package food.foodproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberJoinDto {

    private String nickname;
    private String email;
    private String phone;
    private String password;
}

package food.foodproject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Data
public class MemberJoinDto {

    private String nickname;
    private String email;
    private String phone;
    private String password;
}

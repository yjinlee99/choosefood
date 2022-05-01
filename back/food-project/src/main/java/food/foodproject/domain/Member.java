package food.foodproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//회원 테이블
@Entity
@Getter @Setter
public class Member {
    //아이디 (기본키)
    @Id
    @Column(name = "member_id")
    private Long id;

    //비밀번호
    private String password;

    //이름
    private String name;

    //닉네임
    private String nickname;

    //핸드폰 번호
    private Long phone;

    //냉장고 재료
    private String having_ingredient;
}

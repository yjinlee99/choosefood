package food.foodproject.domain;

import food.foodproject.dto.MemberFormDto;
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
    //일련번호
    @Id
    @GeneratedValue
    @Column(name = "member_id", unique = true)
    private Long id;

    //비밀번호
    private String password;

    //아이디
    private String name;

    //닉네임
    private String nickname;

    //핸드폰 번호
    private Long phone;

    //냉장고 재료
    private String havingIngredient;

    //냉장고 수정
    public void modHavingIngredient(String food){
        this.havingIngredient = food;
    }

}

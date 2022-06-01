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
    //일련번호
    @Id
    @GeneratedValue
    @Column(name = "member_id", unique = true)
    private Long id;

    //비밀번호
    private String password;

    //닉네임
    @Column (unique = true)
    private String nickname;

    //핸드폰 번호
    private String phone;

    //이메일
    @Column (unique = true)
    private String email;

    //이미지
    private String img;

    //냉장고 재료
    private String havingIngredient;

    //닉네임 수정
    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    //핸드폰 번호 수정
    public void updatePhone(String phone) {
        this.phone = phone;
    }

    //이메일 수정
    public void updateEmail(String email) {
        this.email = email;
    }

    //비밀번호 수정
    public void updatePassword(String password) {
        this.password = password;
    }

    //냉장고 수정
    public void updateHavingIngredient(String havingIngredient){
        this.havingIngredient = havingIngredient;
    }

    //이미지 수정
    public void updateImg(String img) { this.img = img; }


}
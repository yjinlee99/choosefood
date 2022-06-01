package food.foodproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

//음식 테이블
@Entity
@Getter @Setter
public class Food {
    
    //기본키
    @Id
    @GeneratedValue
    @Column(name = "food_id",unique = true)
    private Long id;

    //이름
    private String name;

    //소개
    private String intro;

    //재료
    private String ingredient;

    //레시피
    @Column(columnDefinition = "text")
    private String recipe;

    //테마별
    private String theme;

    //미각별
    private String taste;

    //상황별
    private String situation;

    //썸네일 이미지
    private String thumbnail;
    
    //스텝 이미지
    @Column(columnDefinition = "text")
    private String stepImg;
}

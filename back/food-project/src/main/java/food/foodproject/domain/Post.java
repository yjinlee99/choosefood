package food.foodproject.domain;

//게시물 테이블

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class Post {
    //일련번호 (기본키)
    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    //사용자 아이디 (외래키)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

    //제목
    private String title;

    //날짜
    private LocalDateTime uploadDate;

    //요리 소개
    private String introduce;

    //썸네일 사진
    private String thumbImg;

    //재료
    private String ingredient;

    //내용
    private String recipe;

    //스탭 사진
    private String stepImg;

    //조회수
    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;

    public void updateView() { this.view++; }

}

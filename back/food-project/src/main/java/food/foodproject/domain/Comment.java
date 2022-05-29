package food.foodproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Comment {
    //댓글 일련 번호
    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    //게시판 일련 번호
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    //회원 아이디
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //작성 시간
    private LocalDateTime date;

    //내용
    private String content;
}
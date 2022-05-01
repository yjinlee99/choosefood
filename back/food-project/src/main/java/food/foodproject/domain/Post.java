package food.foodproject.domain;

//게시물 테이블

import lombok.Getter;
import lombok.Setter;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
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
    private Member member;

}

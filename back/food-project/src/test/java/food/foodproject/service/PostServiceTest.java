package food.foodproject.service;

import food.foodproject.domain.Member;
import food.foodproject.domain.Post;
import food.foodproject.dto.PostShowAllDto;
import food.foodproject.repository.MemberRepository;
import food.foodproject.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostServiceTest {
    @Autowired PostService postService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PostRepository postRepository;

    @Test
    public void 게시판() {
        Member member = new Member();
        member.setNickname("nick");
        member.setEmail("a");
        member.setImg("img");

        memberRepository.save(member);

        Post post = new Post();
        post.setTitle("냠냠");
        post.setMember(member);

        postRepository.save(post);

        Member member1 = new Member();
        member1.setNickname("name");
        member1.setEmail("b");
        member1.setImg("img1");

        memberRepository.save(member1);

        Post post1 = new Post();
        post1.setTitle("쩝쩝");
        post1.setMember(member1);

        postRepository.save(post1);

        List<PostShowAllDto> posts = postService.findAll();

        System.out.println(posts);
    }


}
package food.foodproject.service;

import food.foodproject.domain.Member;
import food.foodproject.domain.Post;
import food.foodproject.dto.PostSaveDto;
import food.foodproject.dto.PostShowAllDto;
import food.foodproject.repository.MemberRepository;
import food.foodproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public Long save(PostSaveDto dto) {

        Member member = memberRepository.findOne(dto.getMemberId());
        Post post = new Post();
        post.setMember(member);
        post.setTitle(dto.getTitle());
        post.setFoodName(dto.getFoodName());
        post.setIngredient(dto.getIngredient());
        post.setRecipe(dto.getRecipe());
        post.setUploadDate(LocalDateTime.now());

        postRepository.save(post);

        return post.getId();
    }

    public List<PostShowAllDto> findAll() {
        return postRepository.findShowAll();
    }
    public Post findOne(String title) {
        System.out.println(title);
        return postRepository.findByTitle(title);
    }


}

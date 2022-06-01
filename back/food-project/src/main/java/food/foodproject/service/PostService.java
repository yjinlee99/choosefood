package food.foodproject.service;

import food.foodproject.domain.Member;
import food.foodproject.domain.Post;
import food.foodproject.dto.PostSaveDto;
import food.foodproject.dto.PostShowAllDto;
import food.foodproject.dto.PostSingleDto;
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

    @Transactional
    public Long save(PostSaveDto dto) {

        Member member = memberRepository.findOne(dto.getMemberId());
        Post post = new Post();
        post.setMember(member);
        post.setTitle(dto.getTitle());
        post.setThumbImg(dto.getThumbImg());
        post.setIntroduce(dto.getIntroduce());
        post.setIngredient(dto.getIngredient());
        post.setRecipe(dto.getRecipe());
        post.setStepImg(dto.getStepImg());
        post.setUploadDate(LocalDateTime.now());

        postRepository.save(post);

        return post.getId();
    }

    public List<PostShowAllDto> findAll() {
        return postRepository.findShowAll();
    }

    public List<PostShowAllDto> findByUser(Long id) {
        return postRepository.findByUser(id);
    }

    @Transactional
    public PostSingleDto findOne(String title) {
        Post post = postRepository.findByTitle(title);
        post.updateView();
        PostSingleDto dto = postRepository.findSinglePost(title);
        return dto;
    }




}

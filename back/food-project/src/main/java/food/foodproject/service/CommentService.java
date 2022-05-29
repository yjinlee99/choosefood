package food.foodproject.service;

import food.foodproject.domain.Comment;
import food.foodproject.domain.Member;
import food.foodproject.domain.Post;
import food.foodproject.dto.CommentShowDto;
import food.foodproject.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Transactional
    public Long save (Long postId, Long userId, String content) {

        Member member = memberRepository.findOne(userId);
        Post post = postRepository.findOne(postId);

        Comment comment = new Comment();
        comment.setMember(member);
        System.out.println(member.getId());
        comment.setPost(post);
        System.out.println(post.getId());
        comment.setContent(content);
        comment.setDate(LocalDateTime.now());

        commentRepository.save(comment);

        return comment.getId();
    }


    public List<CommentShowDto> findByPostId(Long id) {
        return commentRepository.findByPostId(id);
    }
    public List<CommentShowDto> findByUserId(Long id) {
        return commentRepository.findByUserId(id);
    }
}

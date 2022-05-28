package food.foodproject.service;

import food.foodproject.domain.Comment;
import food.foodproject.domain.Member;
import food.foodproject.domain.Post;
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
    public Long save (Long userId, Long postId, String content) {

        Member member = memberRepository.findOne(userId);
        Post post = postRepository.findOne(postId);

        Comment comment = new Comment();
        comment.setMember(member);
        comment.setPost(post);
        comment.setContent(content);
        comment.setDate(LocalDateTime.now());

        commentRepository.save(comment);

        return comment.getId();
    }


    public List<Comment> findByPostId(Long id) {
        return commentRepository.findByPostId(id);
    }
    public List<Comment> findByUserId(Long id) {
        return commentRepository.findByUserId(id);
    }
}

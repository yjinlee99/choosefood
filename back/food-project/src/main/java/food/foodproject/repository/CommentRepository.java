package food.foodproject.repository;

import food.foodproject.domain.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CommentRepository {

    @PersistenceContext
    private EntityManager em;

    public void save (Comment comment) {
        em.persist(comment);
    }

    public Comment findOne (Long id) {
        return em.find(Comment.class, id);
    }

    public List<Comment> findByPostId (Long id) {
        return em.createQuery("select * from Comment m where m.post_id like :id")
                .getResultList();
    }

    public List<Comment> findByUserId (Long id) {
        return em.createQuery("select * from Comment m where m.user_id like :id")
                .getResultList();
    }
 }

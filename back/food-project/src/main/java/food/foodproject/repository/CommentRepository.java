package food.foodproject.repository;

import food.foodproject.domain.Comment;
import food.foodproject.dto.CommentShowDto;
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

    public List<CommentShowDto> findByPostId (Long id) {
        return em.createQuery("select new food.foodproject.dto.CommentShowDto(m.nickname, m.img, c.content)"
                    + " from Comment c "
                    + " join c.member m "
                    + " join c.post p "
                    + " where p.id = :id", CommentShowDto.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<CommentShowDto> findByUserId (Long id) {
        return em.createQuery("select new food.foodproject.dto.CommentShowDto(m.nickname, m.img, c.content)"
                        + " from Comment c "
                        + " join c.member m "
                        + " where m.id = :id", CommentShowDto.class)
                .setParameter("id", id)
                .getResultList();
    }
 }

package food.foodproject.repository;

import food.foodproject.domain.Member;
import food.foodproject.domain.Post;
import food.foodproject.dto.PostShowAllDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Post post) {em.persist(post);}

    public Post findOne (Long id) {return em.find(Post.class, id);}

    public List<Post> findAll () {
        return em.createQuery("select * from Post m", Post.class)
                .getResultList();
    }


    public List<PostShowAllDto> findShowAll() {
        return em.createQuery(
                "select new food.foodproject.dto.PostShowAllDto(p.title, m.nickname, m.img)"
                            +" from Post p "
                            +" join p.member m ",PostShowAllDto.class)
                .getResultList();
    }

    public Post findByTitle(String title) {
        return em.createQuery("select m from Member m where m.title = :title",
                        Post.class)
                .setParameter("title", title)
                .getSingleResult();
    }
}

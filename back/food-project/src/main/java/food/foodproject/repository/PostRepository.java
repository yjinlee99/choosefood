package food.foodproject.repository;

import food.foodproject.domain.Member;
import food.foodproject.domain.Post;
import food.foodproject.dto.PostShowAllDto;
import food.foodproject.dto.PostSingleDto;
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
                "select new food.foodproject.dto.PostShowAllDto(p.title, m.nickname, m.img, p.thumbImg, p.view, p.uploadDate)"
                            +" from Post p "
                            +" join p.member m ",PostShowAllDto.class)
                .getResultList();
    }

    public Post findByTitle(String title) {
        return em.createQuery("select m from Post m where m.title = :title",
                        Post.class)
                .setParameter("title", title)
                .getSingleResult();
    }

    public List<PostShowAllDto> findByUser(Long id) {
        return em.createQuery(
                        "select new food.foodproject.dto.PostShowAllDto(p.title, m.nickname, m.img, p.thumbImg, p.view, p.uploadDate)"
                                +" from Post p "
                                +" join p.member m "
                                +" where m.id = :id",PostShowAllDto.class)
                .setParameter("id" , id)
                .getResultList();
    }

    public PostSingleDto findSinglePost(String title) {
        return em.createQuery(
                "select new food.foodproject.dto.PostSingleDto(p.id, p.title, p.uploadDate, p.introduce, p.thumbImg, p.ingredient, p.recipe, p.stepImg, p.view, m.img)"
                            + " from Post p "
                            + " join p.member m "
                            + " where p.title = :title ",PostSingleDto.class)
                .setParameter("title", title)
                .getSingleResult();
    }
}

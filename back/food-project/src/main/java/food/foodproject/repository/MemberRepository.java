package food.foodproject.repository;

import food.foodproject.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository{

    @PersistenceContext
    private EntityManager em;

    public void save (Member member) {
        em.persist(member);
    }

    public Member findOne (Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll ( ) {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Member login (String email, String password) {
        return em.createQuery("select m from Member m where m.email like :email and m.password like :password ", Member.class)
                .getSingleResult();
    }
}
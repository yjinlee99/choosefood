package food.foodproject.repository;

import food.foodproject.domain.Member;
import org.springframework.stereotype.Repository;

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
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
    }

    public List<Member> findByNickname(String nickname) {
        return em.createQuery("select m from Member m where m.nickname = :nickname",
                        Member.class)
                .setParameter("nickname", nickname)
                .getResultList();
    }

    public List<Member> findByEmail(String email) {
        return em.createQuery("select m from Member m where m.email = :email",
                        Member.class)
                .setParameter("email", email)
                .getResultList();
    }

}
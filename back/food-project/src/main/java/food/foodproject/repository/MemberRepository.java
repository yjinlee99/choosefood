package food.foodproject.repository;

import food.foodproject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long>{
    Optional<Member> findByNickname(String name);
}

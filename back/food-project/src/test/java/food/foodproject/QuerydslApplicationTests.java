package food.foodproject;

import com.querydsl.jpa.impl.JPAQueryFactory;
import food.foodproject.domain.Food;
import food.foodproject.domain.QFood;
import food.foodproject.dto.QFoodDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class QuerydslApplicationTests {

    @Autowired
    EntityManager em;

    @Test
    void contextLoads(){
        Food food1 = new Food();
        em.persist(food1);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QFoodDto qFoodDto = new QFoodDto("h");

        Food result = query
                .selectFrom(qfood)
                .fetchOne();

        assertThat(result).isEqualTo(hello);
        assertThat(result.getId()).isEqualTo(hello.getId());
    }
    }
}

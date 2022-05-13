package food.foodproject.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import food.foodproject.domain.Food;
import static food.foodproject.domain.QFood.food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class FoodRepositoryImpl extends QuerydslRepositorySupport implements FoodRepositoryCustom {
    @Autowired
    private JPAQueryFactory queryFactory;

    public FoodRepositoryImpl() {
        super(Food.class);
    }

    @Override
    public Page<Food> findBySearchOption(Pageable pageable, String name, String ingredients, String recipe,
                                  String theme, String cook, String taste, String situation, String img){
        JPQLQuery<Food> query = queryFactory.selectFrom(food)
                .where(eqingredients(ingredients), eqtheme(theme), eqcook(cook), eqtaste(taste), eqsituation(situation));

        List<Food> foods = this.getQuerydsl().applyPagination(pageable,query).fetch();
        return new PageImpl<Food>(foods, pageable, query.fetchCount());
    }

    private BooleanExpression eqingredients(String ingredients) {
        if(ingredients == null || ingredients.isEmpty()) {
            return null;
        }
        return food.ingredients.eq(ingredients);
    }
    private BooleanExpression eqtheme(String theme) {
        if(theme == null || theme.isEmpty()) {
            return null;
        }
        return food.theme.eq(theme);
    }
    private BooleanExpression eqcook(String cook) {
        if(cook == null || cook.isEmpty()) {
            return null;
        }
        return food.cook.eq(cook);
    }
    private BooleanExpression eqtaste(String taste) {
        if(taste == null || taste.isEmpty()) {
            return null;
        }
        return food.taste.eq(taste);
    }
    private BooleanExpression eqsituation(String situation) {
        if(situation == null || situation.isEmpty()) {
            return null;
        }
        return food.situation.eq(situation);
    }
}

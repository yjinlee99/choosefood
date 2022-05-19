package food.foodproject.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static food.foodproject.domain.QFood.food;

import food.foodproject.domain.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
public class FoodRepositoryImpl implements FoodRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Food> findBySearchOption(List<String> themes, List<String> tastes, List<String> ingredients, List<String> situations) {

        return jpaQueryFactory.select(food).from(food)
                .where(foodIsNotNull())
                .where(food.theme.in(themes))
                .where(food.taste.in(tastes))
                .where(ingredientEq(ingredients))
                .where(food.situation.in(situations))
                .fetch();
    }


    private BooleanExpression foodIsNotNull(){
        return food.id.isNotNull();
    }

    private BooleanBuilder ingredientEq(List<String> ingredientCondition){
        BooleanBuilder builder = new BooleanBuilder();

        if(ingredientCondition.contains("고기")){
            builder.or(food.ingredient.contains("돼지"))
                    .or(food.ingredient.contains("닭"))
                    .or(food.ingredient.contains("소"))
                    .or(food.ingredient.contains("만두"))
                    .or(food.name.contains("돼지"))
                    .or(food.name.contains("닭"))
                    .or(food.name.contains("소"))
                    .or(food.name.contains("만두"));
        }
        if(ingredientCondition.contains("채소")){
            builder.or(food.name.contains("감자"))
                    .or(food.name.contains("버섯"))
                    .or(food.name.contains("배추"))
                    .or(food.name.contains("김치"))
                    .or(food.name.contains("나물"))
                    .or(food.name.contains("나베"))
                    .or(food.name.contains("고구마"))
                    .or(food.name.contains("상추"))
                    .or(food.name.contains("토마토"));
        }
        if(ingredientCondition.contains("떡")){
            builder.or(food.name.contains("떡"))
                    .or(food.ingredient.contains("떡"));
        }
        if(ingredientCondition.contains("밥")){
            builder.or(food.name.contains("밥"))
                    .or(food.ingredient.contains("밥"))
                    .or(food.ingredient.contains("쌀"));
        }
        if(ingredientCondition.contains("해물")){
            builder.or(food.name.contains("미역"))
                    .or(food.name.contains("참치"))
                    .or(food.name.contains("낙지"))
                    .or(food.name.contains("쭈꾸미"))
                    .or(food.name.contains("주꾸미"))
                    .or(food.name.contains("우동"))
                    .or(food.name.contains("어묵"))
                    .or(food.name.contains("해물"))
                    .or(food.name.contains("새우"))
                    .or(food.name.contains("초밥"))
                    .or(food.name.contains("회"));
        }
        if(ingredientCondition.contains("과일")){
            builder.or(food.name.contains("딸기"))
                    .or(food.name.contains("토마토"))
                    .or(food.name.contains("사과"))
                    .or(food.name.contains("포도"))
                    .or(food.name.contains("메론"))
                    .or(food.name.contains("멜론"))
                    .or(food.name.contains("복숭아"))
                    .or(food.name.contains("귤"))
                    .or(food.name.contains("오렌지"))
                    .or(food.name.contains("망고"))
                    .or(food.name.contains("체리"))
                    .or(food.name.contains("블루베리"));
        }
        if(ingredientCondition.contains("빵,과자")){
            builder.or(food.theme.contains("빵"))
                    .or(food.name.contains("미역"));
        }
        if(ingredientCondition.contains("두부,계란,우유")){
            builder.and(food.theme.contains("두부"));
            builder.and(food.theme.contains("계란"));
            builder.and(food.theme.contains("우유"));
        }
        if(ingredientCondition.contains("면")){
            builder.and(food.theme.contains("면"));
        }
        return builder;
    }

}

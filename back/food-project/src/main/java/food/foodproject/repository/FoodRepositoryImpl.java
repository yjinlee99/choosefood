package food.foodproject.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static food.foodproject.domain.QFood.food;

import food.foodproject.dto.FoodDto;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.dto.QFoodDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FoodRepositoryImpl implements FoodRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<FoodDto> findBySearchOption(FoodOptionDto condition) {

        return queryFactory

                        .select(new QFoodDto(food))
                        .distinct()
                        .from(food)
                        .where(
                            foodIsNotNull(),
                            tasteEq(condition.getTaste()),
                            ingredientEq(condition.getIngredients()),
                            cookEq(condition.getCook())
                            )
                        .fetch();

    }

    private BooleanExpression foodIsNotNull(){
        return food.id.isNotNull();
    }

    private BooleanBuilder tasteEq(List<String> tasteCondition){
        BooleanBuilder builder = new BooleanBuilder();

        if(tasteCondition.contains("매콤")){
            builder.or(food.taste.contains("매콤"));
        }
        if(tasteCondition.contains("달콤")){
            builder.or(food.taste.contains("달콤"));
        }
        if(tasteCondition.contains("고소")){
            builder.or(food.taste.contains("고소"));
        }
        if(tasteCondition.contains("짭짤")){
            builder.or(food.taste.contains("짭짤"));
        }
        return builder;
    }

    private BooleanBuilder ingredientEq(List<String> ingredientCondition){
        BooleanBuilder builder = new BooleanBuilder();

        if(ingredientCondition.contains("고기")){
            builder.or(food.ingredients.contains("돼지"))
                    .or(food.ingredients.contains("닭"))
                    .or(food.ingredients.contains("소"))
                    .or(food.ingredients.contains("만두"))
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
                    .or(food.ingredients.contains("떡"));
        }
        if(ingredientCondition.contains("밥")){
            builder.or(food.name.contains("밥"))
                    .or(food.ingredients.contains("밥"))
                    .or(food.ingredients.contains("쌀"));
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
                    .or(food.name.contains("회"))
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
                    .or(food.name.contains("미역"))
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

    private BooleanBuilder cookEq(List<String> cookCondition){
        BooleanBuilder builder = new BooleanBuilder();

        if(cookCondition.contains("")){
            builder.and(food.taste.contains("매콤"));
        }
        if(cookCondition.contains("달콤")){
            builder.and(food.taste.contains("달콤"));
        }
        if(cookCondition.contains("고소")){
            builder.and(food.taste.contains("고소"));
        }
        if(cookCondition.contains("짭짤")){
            builder.and(food.taste.contains("짭짤"));
        }
        return builder;
    }

}

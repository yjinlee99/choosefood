package food.foodproject.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static food.foodproject.domain.QFood.food;

import food.foodproject.domain.Food;
import food.foodproject.dto.FoodDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class FoodRepositoryImpl implements FoodRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<FoodDto> findBySearch(String str) {
        return jpaQueryFactory
                                    .select(Projections.bean(FoodDto.class,
                                            food.name,
                                            food.thumbnail
                                    ))
                                    .from(food)
                                    .where(foodIsNotNull())
                                    .where(searchEq(str))
                                    .fetch();
    }

    private BooleanBuilder searchEq(String str) {
        BooleanBuilder builder = new BooleanBuilder();

        builder.or(food.name.contains(str))
                .or(food.ingredient.contains(str))
                .or(food.situation.contains(str))
                .or(food.intro.contains(str))
                .or(food.taste.contains(str))
                .or(food.theme.contains(str));

        return builder;
    }

    @Override
    public List<FoodDto> findBySearchRefrigerator(List<String> ingredients) {
//        System.out.println(ingredients);
        List<FoodDto> foodDto = jpaQueryFactory
                                    .select(Projections.bean(FoodDto.class,
                                            food.name,
                                            food.thumbnail
                                    ))
                                    .from(food)
                                    .where(foodIsNotNull())
                                    .where(refEq(ingredients))
                                    .fetch();
        return foodDto;
    }

    private BooleanBuilder refEq(List<String> ingredients){
        BooleanBuilder builder = new BooleanBuilder();

        for(int i=0; i<ingredients.size(); i++)
            builder.or(food.ingredient.contains(ingredients.get(i)));

        return builder;
    }

    @Override
    public List<FoodDto> findBySearchOption(List<String> themes, List<String> tastes, List<String> ingredients, List<String> situations) {

        System.out.println(themes);
        List<FoodDto> foodDto = jpaQueryFactory
                                    .select(Projections.bean(FoodDto.class,
                                            food.name,
                                            food.thumbnail
                                    ))
                                    .from(food)
                                    .where(foodIsNotNull())
                                    .where(themeEq(themes))
                                    .where(tasteEq(tastes))
                                    .where(ingredientEq(ingredients))
                                    .where(situationEq(situations))
                                    .fetch();

        return foodDto;
    }


    private BooleanExpression foodIsNotNull(){
        return food.id.isNotNull();
    }

    private BooleanBuilder themeEq(List<String> themeCondition){
        System.out.println(themeCondition);
        BooleanBuilder builder = new BooleanBuilder();

        if(themeCondition.contains("한식")) {
            builder.or(food.theme.contains("한식"));
        }
        if(themeCondition.contains("중식")){
            builder.or(food.theme.contains("중식"));
        }
        if(themeCondition.contains("일식")) {
            builder.or(food.theme.contains("일식"));
        }
        if(themeCondition.contains("양식")) {
            builder.or(food.theme.contains("양식"));
        }
        if(themeCondition.contains("분식")) {
            builder.or(food.theme.contains("분식"));
        }
        if(themeCondition.contains("디저트")) {
            builder.or(food.theme.contains("디저트"));
        }
        return builder;
    }

    private BooleanBuilder tasteEq(List<String> tasteCondition){
        BooleanBuilder builder = new BooleanBuilder();

        if(tasteCondition.contains("매콤")) {
            builder.or(food.taste.contains("매콤"));
        }
        if(tasteCondition.contains("달콤")){
            builder.or(food.taste.contains("달콤"));
        }
        if(tasteCondition.contains("짭짤")) {
            builder.or(food.taste.contains("짭짤"));
        }
        if(tasteCondition.contains("고소")) {
            builder.or(food.taste.contains("고소"));
        }
        return builder;
    }

    private BooleanBuilder ingredientEq(List<String> ingredientCondition){
        BooleanBuilder builder = new BooleanBuilder();

        if(ingredientCondition.contains("고기")){
            builder.or(food.ingredient.contains("돼지"))
                    .or(food.ingredient.contains("닭"))
                    .or(food.ingredient.contains("고기"))
                    .or(food.ingredient.contains("만두"))
                    .or(food.name.contains("돼지"))
                    .or(food.name.contains("닭"))
                    .or(food.name.contains("고기"))
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
            builder.or(food.name.contains("빵"))
                    .or(food.name.contains("토스트"))
                    .or(food.name.contains("피자"))
                    .or(food.name.contains("밀가루"))
                    .or(food.name.contains("케이크"))
                    .or(food.name.contains("박력분"))
                    .or(food.name.contains("파우더"))
                    .or(food.name.contains("오레오"))
                    .or(food.name.contains("푸딩"))
                    .or(food.name.contains("쿠키"))
                    .or(food.ingredient.contains("빵"))
                    .or(food.ingredient.contains("토스트"))
                    .or(food.ingredient.contains("피자"))
                    .or(food.ingredient.contains("밀가루"))
                    .or(food.ingredient.contains("케이크"))
                    .or(food.ingredient.contains("박력분"))
                    .or(food.ingredient.contains("파우더"))
                    .or(food.ingredient.contains("오레오"))
                    .or(food.ingredient.contains("푸딩"))
                    .or(food.ingredient.contains("쿠키"));
        }
        if(ingredientCondition.contains("두부,계란,우유")){
            builder.or(food.name.contains("두부"))
                    .or(food.name.contains("계란"))
                    .or(food.name.contains("달걀"))
                    .or(food.name.contains("우유"))
                    .or(food.name.contains("버터"))
                    .or(food.name.contains("치즈"))
                    .or(food.name.contains("분유"))
                    .or(food.name.contains("크림"))
                    .or(food.ingredient.contains("두부"))
                    .or(food.ingredient.contains("계란"))
                    .or(food.ingredient.contains("달걀"))
                    .or(food.ingredient.contains("우유"))
                    .or(food.ingredient.contains("버터"))
                    .or(food.ingredient.contains("치즈"))
                    .or(food.ingredient.contains("분유"))
                    .or(food.ingredient.contains("크림"));

        }
        if(ingredientCondition.contains("면")){
            builder.or(food.name.contains("면"))
                    .or(food.name.contains("라면"))
                    .or(food.name.contains("라멘"))
                    .or(food.name.contains("국수"))
                    .or(food.ingredient.contains("면"))
                    .or(food.ingredient.contains("라면"))
                    .or(food.ingredient.contains("라멘"))
                    .or(food.ingredient.contains("국수"));
        }
        return builder;
    }

    private BooleanBuilder situationEq(List<String> situationCondition){
        BooleanBuilder builder = new BooleanBuilder();

        if(situationCondition.contains("야식")) {
            builder.or(food.situation.contains("야식"));
        }
        if(situationCondition.contains("술안주")){
            builder.or(food.situation.contains("술안주"));
        }
        if(situationCondition.contains("식사")) {
            builder.or(food.situation.contains("식사"));
        }
        if(situationCondition.contains("간식")) {
            builder.or(food.situation.contains("간식"));
        }
        if(situationCondition.contains("해장")) {
            builder.or(food.situation.contains("해장"));
        }
        if(situationCondition.contains("기타")) {
            builder.or(food.situation.contains("기타"));
        }
        return builder;
    }

}
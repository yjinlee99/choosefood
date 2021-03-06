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

        if(themeCondition.contains("??????")) {
            builder.or(food.theme.contains("??????"));
        }
        if(themeCondition.contains("??????")){
            builder.or(food.theme.contains("??????"));
        }
        if(themeCondition.contains("??????")) {
            builder.or(food.theme.contains("??????"));
        }
        if(themeCondition.contains("??????")) {
            builder.or(food.theme.contains("??????"));
        }
        if(themeCondition.contains("??????")) {
            builder.or(food.theme.contains("??????"));
        }
        if(themeCondition.contains("?????????")) {
            builder.or(food.theme.contains("?????????"));
        }
        return builder;
    }

    private BooleanBuilder tasteEq(List<String> tasteCondition){
        BooleanBuilder builder = new BooleanBuilder();

        if(tasteCondition.contains("??????")) {
            builder.or(food.taste.contains("??????"));
        }
        if(tasteCondition.contains("??????")){
            builder.or(food.taste.contains("??????"));
        }
        if(tasteCondition.contains("??????")) {
            builder.or(food.taste.contains("??????"));
        }
        if(tasteCondition.contains("??????")) {
            builder.or(food.taste.contains("??????"));
        }
        return builder;
    }

    private BooleanBuilder ingredientEq(List<String> ingredientCondition){
        BooleanBuilder builder = new BooleanBuilder();

        if(ingredientCondition.contains("??????")){
            builder.or(food.ingredient.contains("??????"))
                    .or(food.ingredient.contains("???"))
                    .or(food.ingredient.contains("??????"))
                    .or(food.ingredient.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("???"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"));
        }
        if(ingredientCondition.contains("??????")){
            builder.or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("?????????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("?????????"));
        }
        if(ingredientCondition.contains("???")){
            builder.or(food.name.contains("???"))
                    .or(food.ingredient.contains("???"));
        }
        if(ingredientCondition.contains("???")){
            builder.or(food.name.contains("???"))
                    .or(food.ingredient.contains("???"))
                    .or(food.ingredient.contains("???"));
        }
        if(ingredientCondition.contains("??????")){
            builder.or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("?????????"))
                    .or(food.name.contains("?????????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("???"));
        }
        if(ingredientCondition.contains("??????")){
            builder.or(food.name.contains("??????"))
                    .or(food.name.contains("?????????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("?????????"))
                    .or(food.name.contains("???"))
                    .or(food.name.contains("?????????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("????????????"));
        }
        if(ingredientCondition.contains("???,??????")){
            builder.or(food.name.contains("???"))
                    .or(food.name.contains("?????????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("?????????"))
                    .or(food.name.contains("?????????"))
                    .or(food.name.contains("?????????"))
                    .or(food.name.contains("?????????"))
                    .or(food.name.contains("?????????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.ingredient.contains("???"))
                    .or(food.ingredient.contains("?????????"))
                    .or(food.ingredient.contains("??????"))
                    .or(food.ingredient.contains("?????????"))
                    .or(food.ingredient.contains("?????????"))
                    .or(food.ingredient.contains("?????????"))
                    .or(food.ingredient.contains("?????????"))
                    .or(food.ingredient.contains("?????????"))
                    .or(food.ingredient.contains("??????"))
                    .or(food.ingredient.contains("??????"));
        }
        if(ingredientCondition.contains("??????,??????,??????")){
            builder.or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.ingredient.contains("??????"))
                    .or(food.ingredient.contains("??????"))
                    .or(food.ingredient.contains("??????"))
                    .or(food.ingredient.contains("??????"))
                    .or(food.ingredient.contains("??????"))
                    .or(food.ingredient.contains("??????"))
                    .or(food.ingredient.contains("??????"))
                    .or(food.ingredient.contains("??????"));

        }
        if(ingredientCondition.contains("???")){
            builder.or(food.name.contains("???"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.name.contains("??????"))
                    .or(food.ingredient.contains("???"))
                    .or(food.ingredient.contains("??????"))
                    .or(food.ingredient.contains("??????"))
                    .or(food.ingredient.contains("??????"));
        }
        return builder;
    }

    private BooleanBuilder situationEq(List<String> situationCondition){
        BooleanBuilder builder = new BooleanBuilder();

        if(situationCondition.contains("??????")) {
            builder.or(food.situation.contains("??????"));
        }
        if(situationCondition.contains("?????????")){
            builder.or(food.situation.contains("?????????"));
        }
        if(situationCondition.contains("??????")) {
            builder.or(food.situation.contains("??????"));
        }
        if(situationCondition.contains("??????")) {
            builder.or(food.situation.contains("??????"));
        }
        if(situationCondition.contains("??????")) {
            builder.or(food.situation.contains("??????"));
        }
        if(situationCondition.contains("??????")) {
            builder.or(food.situation.contains("??????"));
        }
        return builder;
    }

}
package food.foodproject.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static food.foodproject.domain.QFood.food;

import food.foodproject.domain.Food;
import food.foodproject.dto.FoodDto;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.dto.QFoodDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FoodRepositoryImpl implements FoodRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    private final JPAQueryFactory jpaQueryFactory;

    public List<Food> findFoods(String theme) {
        return em.createQuery("select f from Food f " +
                " where f.theme = :theme", Food.class)
                .setParameter("theme", theme).getResultList();
    }

    public List<Food> findFoodsInSearch(List<String> themes, List<String> tastes, List<String> ingredients, List<String> situations) {
        String sql = "select f from Food f";
        boolean isContainsWhere = false;
        if(themes != null && themes.size() != 0) {
            if(isContainsWhere) sql += " and ";
            else{
                isContainsWhere = true;
                sql += " where ";
            }
            sql += "f.theme in :theme";
        }
        if(tastes != null && tastes.size() != 0) {
            if(isContainsWhere) sql += " and ";
            else{
                isContainsWhere = true;
                sql += " where ";
            }
            sql += "f.taste in :taste";
        }
        if(ingredients != null && ingredients.size() != 0) {
            if(isContainsWhere) sql += " and ";
            else{
                isContainsWhere = true;
                sql += " where ";
            }
            sql += "f.ingredient in :ingredient";
        }
        if(situations != null && situations.size() != 0) {
            if(isContainsWhere) sql += " and ";
            else{
                isContainsWhere = true;
                sql += " where ";
            }
            sql += "f.situation in :situations";
        }
        Query query = em.createQuery(sql);
        if(themes != null && themes.size() != 0) query.setParameter("theme", themes);
        if(tastes != null && tastes.size() != 0) query.setParameter("taste", tastes);
        if(ingredients != null && ingredients.size() != 0) query.setParameter("ingredient", ingredients);
        if(situations != null && situations.size() != 0) query.setParameter("situations", situations);
        return query.getResultList();
    }

    public List<Food> findFoodsInSearch2(List<String> themes, List<String> tastes, List<String> ingredients, List<String> situations) {

        return jpaQueryFactory.select(food).from(food)
                .where(food.theme.in(themes))
                .where(food.taste.in(tastes))
                .where(food.ingredient.in(ingredients))
                .where(food.situation.in(situations))
                .fetch();
    }

        @Override
    public List<FoodDto> findBySearchOption(FoodOptionDto condition) {
        return jpaQueryFactory

                        .select(new QFoodDto(food))
                        .distinct()
                        .from(food)
                        .where(
                            foodIsNotNull(),
                            themeEq(condition.getTheme()),
                            tasteEq(condition.getTaste()),
                            ingredientEq(condition.getIngredients()),
                            situationEq(condition.getSituations())
                            )
                        .fetch();

    }

    private BooleanExpression foodIsNotNull(){
        return food.id.isNotNull();
    }

    private BooleanBuilder themeEq(List<String> themeCondition){
        BooleanBuilder builder = new BooleanBuilder();

        if(themeCondition.contains("한식")){
            builder.or(food.theme.contains("한식"));
        }
        if(themeCondition.contains("중식")){
            builder.or(food.theme.contains("중식"));
        }
        if(themeCondition.contains("일식")){
            builder.or(food.theme.contains("일식"));
        }
        if(themeCondition.contains("양식")){
            builder.or(food.theme.contains("양식"));
        }
        if(themeCondition.contains("분식")){
            builder.or(food.theme.contains("분식"));
        }
        if(themeCondition.contains("디저트")){
            builder.or(food.theme.contains("디저트"));
        }
        return builder;
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

    private BooleanBuilder situationEq(List<String> situationCondition){
        BooleanBuilder builder = new BooleanBuilder();

        if(situationCondition.contains("야식")){
            builder.and(food.situation.contains("야식"));
        }
        if(situationCondition.contains("간식")){
            builder.and(food.situation.contains("간식"));
        }
        if(situationCondition.contains("술안주")){
            builder.and(food.situation.contains("술안주"));
        }
        if(situationCondition.contains("해장")){
            builder.and(food.situation.contains("해장"));
        }
        if(situationCondition.contains("식사")){
            builder.and(food.situation.contains("식사"));
        }
        if(situationCondition.contains("기타")){
            builder.and(food.situation.contains("기타"));
        }
        return builder;
    }

}

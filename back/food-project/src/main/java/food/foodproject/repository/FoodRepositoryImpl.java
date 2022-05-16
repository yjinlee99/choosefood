package food.foodproject.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import food.foodproject.domain.Food;
import static food.foodproject.domain.QFood.food;

import food.foodproject.dto.FoodDto;
import food.foodproject.dto.FoodOptionDto;
import food.foodproject.dto.QFoodDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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
                            themeEq(condition.getTheme())
                            )
                        .fetch();

    }

    private BooleanExpression foodIsNotNull(){
        return food.id.isNotNull();
    }

    private BooleanBuilder themeEq(List<String> themeCondition){
        BooleanBuilder builder = new BooleanBuilder();

        if(themeCondition.contains("매콤")){
            builder.and(food.theme.contains("매콤"));
        }
        if(themeCondition.contains("달콤")){
            builder.and(food.theme.contains("달콤"));
        }
        if(themeCondition.contains("고소")){
            builder.and(food.theme.contains("고소"));
        }
        if(themeCondition.contains("짭짤")){
            builder.and(food.theme.contains("짭짤"));
        }
        return builder;
    }


}

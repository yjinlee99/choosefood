package food.foodproject.service;

import food.foodproject.domain.Member;
import food.foodproject.dto.MemberHavingIngredientDto;
import food.foodproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface MemberService {

    /*
     * 회원가입
     * 로그인
     * 정보수정(나중에)
     * 아이디 찾기(나중에)
     * 비밀번호 찾기(나중에)
     * 냉장고 수정
     * */

    public void join(Member member);
    public void UpdateHavingIngredient(long id, MemberHavingIngredientDto memberHavingIngredientDto);
}
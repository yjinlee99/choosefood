package food.foodproject.service;

import food.foodproject.domain.Member;
import food.foodproject.dto.MemberHavingIngredientDto;
import food.foodproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public void join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByNickname(member.getNickname())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    @Override
    public void UpdateHavingIngredient(long id, MemberHavingIngredientDto memberHavingIngredientDto){

    }



}

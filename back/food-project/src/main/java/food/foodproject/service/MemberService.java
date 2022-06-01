package food.foodproject.service;

import food.foodproject.domain.Member;
import food.foodproject.dto.MemberInfoUpdateDto;
import food.foodproject.dto.MemberProfileUpdateDto;
import food.foodproject.dto.MemberRefrigeratorDto;
import food.foodproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findEmail =
                memberRepository.findByEmail(member.getEmail());
        if (!findEmail.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

        List<Member> findNickname =
                memberRepository.findByNickname(member.getNickname());
        if (!findNickname.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }


    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member login(String email, String password) {
        return memberRepository.login(email, password);
    }

    @Transactional
    public String refrigeratorUpdate(MemberRefrigeratorDto dto) {
        Member member = memberRepository.findOne(dto.getId());
        member.updateHavingIngredient(dto.getRefrigerator());
        return member.getHavingIngredient();
    }

    @Transactional
    public Long MemberInfoUpdate(MemberInfoUpdateDto dto) {
        Member member = memberRepository.findOne(dto.getId());
        member.updatePhone(dto.getPhone());
        member.updatePassword(dto.getPassword());
        return member.getId();
    }

    @Transactional
    public Long MemberProfileUpdate(MemberProfileUpdateDto dto) {
        Member member = memberRepository.findOne(dto.getId());
        member.updateNickname(dto.getNickname());
        member.updateImg(dto.getImg());
        return member.getId();
    }

}
package food.foodproject.controller;

import food.foodproject.domain.Member;
import food.foodproject.dto.MemberJoinDto;
import food.foodproject.dto.MemberLoginDto;
import food.foodproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/test")
    public Long join(@RequestBody MemberJoinDto memberJoinDto) {
        Member member= new Member();
        member.setNickname(memberJoinDto.getNickname());
        member.setEmail(memberJoinDto.getEmail());
        member.setPhone(memberJoinDto.getPhone());
        member.setPassword(memberJoinDto.getPassword());

        memberService.join(member);

        return member.getId();
    }

    @PostMapping("/login")
    public Long login(@RequestBody MemberLoginDto dto) {
        Member login = memberService.login(dto.getEmail(), dto.getPassword());
        if(login == null) return -1L;
        else return login.getId();
    }

}

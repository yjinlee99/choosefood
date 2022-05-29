package food.foodproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import food.foodproject.domain.Member;
import food.foodproject.dto.MemberIdDto;
import food.foodproject.dto.MemberJoinDto;
import food.foodproject.dto.MemberLoginDto;
import food.foodproject.dto.MemberRefrigeratorDto;
import food.foodproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public Long join(@RequestBody MemberJoinDto memberJoinDto) {

        System.out.println(memberJoinDto);
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
        if(login == null) return null;
        else return login.getId();
    }

    @GetMapping("/user")
    public Member showMember(@RequestParam Long id) {
        Member member = memberService.findOne(id);

        return member;
    }

    @PostMapping("/ref")
    public String updateRefrigerator(@RequestBody MemberRefrigeratorDto dto) {
        return memberService.refrigeratorUpdate(dto);
    }

}

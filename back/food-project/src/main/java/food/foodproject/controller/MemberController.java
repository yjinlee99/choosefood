package food.foodproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import food.foodproject.domain.Member;
import food.foodproject.dto.*;
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
    public Member login(@RequestBody MemberLoginDto dto) {
        Member login = memberService.login(dto.getEmail(), dto.getPassword());
        if(login == null) return null;
        else {
            System.out.println(memberService.findOne(login.getId()));
            return memberService.findOne(login.getId());
        }
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

    @PostMapping("/updateinfo")
    public Long updateInformation(@RequestBody MemberInfoUpdateDto dto) {
        return memberService.MemberInfoUpdate(dto);
    }

    @PostMapping("/updateprofile")
    public Long updateProfile(@RequestBody MemberProfileUpdateDto dto) {
        return memberService.MemberProfileUpdate(dto);
    }

//    @PostMapping("/login")
//    public Member login(@RequestBody MemberLoginDto dto) {
//        Member login = memberService.login(dto.getEmail(), dto.getPassword());
//        if(login == null) return null;
//        else {
//            System.out.println(memberService.findOne(login.getId()));
//            return memberService.findOne(login.getId());
//        }
//    }
//
//    @GetMapping("/user")
//    public Member showMember(@RequestParam Long id) {
//        Member member = memberService.findOne(id);
//
//        return member;
//    }
//
//    @PostMapping("/ref")
//    public String updateRefrigerator(@RequestBody MemberRefrigeratorDto dto) {
//        return memberService.refrigeratorUpdate(dto);
//    }

}

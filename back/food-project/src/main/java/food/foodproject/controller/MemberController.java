package food.foodproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import food.foodproject.domain.Member;
import food.foodproject.dto.*;
import food.foodproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        member.setHavingIngredient("딸기");
        member.setImg("profile.png");

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

    @PostMapping("/ref/update")
    public String updateRefrigerator(@RequestBody String str) {
        System.out.println(str);
        JSONObject jObject = new JSONObject(str);
        Long id = jObject.getLong("id");
        JSONArray jsonArray = jObject.getJSONArray("havingIngredient");
        String refrigerator = "";
        for(int i=0;i<jsonArray.length();i++) {
            JSONObject arr = jsonArray.getJSONObject(i);
            if(i==0) {
                refrigerator = arr.getString("refrigerator");
            } else {
                refrigerator = refrigerator + "," + arr.getString("refrigerator");
            }
        }
        MemberRefrigeratorDto dto = new MemberRefrigeratorDto();
        dto.setId(id);
        dto.setRefrigerator(refrigerator);
        return memberService.refrigeratorUpdate(dto);
    }

    @PostMapping("/ref/member")
    public List<MemberRefrigeratorDto> memberRefrigerator(@RequestBody String str) {
        System.out.println(str);
        JSONObject jObject = new JSONObject(str);
        Long id = jObject.getLong("id");
        Member member = memberService.findOne(id);
        String ref = member.getHavingIngredient();
        String[] arr = ref.split(",");
        List<MemberRefrigeratorDto> dtoList = new ArrayList<>();
        for(int i=0;i< arr.length;i++) {
            MemberRefrigeratorDto dto = new MemberRefrigeratorDto();
            dto.setId(i+1L);
            dto.setRefrigerator(arr[i]);
            dtoList.add(dto);
        }
        System.out.println(dtoList);
        return dtoList;
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

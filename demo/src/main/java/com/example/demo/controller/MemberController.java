package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
// MemberService 를 주입 받고, MemberService 호출하는 Method
    @Autowired
    private MemberService memberService;

    // PostMapping 을 통해 MemberService 호출하는 Method 생성

//   @PostMapping("members")
//    @ResponseBody
////    input 값을 Json 으로 값을 받는 형식
//    public String memberCreate(@RequestBody Member member){
////        Member 객체를 만들어서 MemberService 매개변수로 전달
//        Member member1 = new Member();
//        member1.setName(member.getName());
//        member1.setEmail(member.getEmail());
//        member1.setPassword(member.getPassword());
//        memberService.create(member1);
//        return "ok";
//    }

    @GetMapping("members/new")
    public String memberCreateForm(){
        return "member/member-register";
    }
    @PostMapping("members/new")
    @ResponseBody
//    input 값을 form-dat 로 받는 형식
    public String memberCreate(@RequestParam(value = "name")String myName,
                               @RequestParam(value = "email")String myEmail,
                               @RequestParam(value = "password")String myPassword)
    {
        Member member1 = new Member();
        member1.setName(myName);
        member1.setEmail(myEmail);
        member1.setPassword(myPassword);
        memberService.create(member1);
        return "ok";
    }

    @GetMapping("members")
    public String memberFindAll(Model model){
        List<Member> members = memberService.findAll();
        model.addAttribute("memberList", members);
        return "member/member-list";
    }

    @GetMapping("member")
    public String memberFindById(@RequestParam(value = "id")Long myId, Model model){
        Member member = memberService.findById(myId);
        model.addAttribute("member", member);
        return "member/member-detail";
    }



}

package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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
//    input 값을 form-dat 로 받는 형식
    public String memberCreate(@RequestParam(value = "name")String myName,
                               @RequestParam(value = "email")String myEmail,
                               @RequestParam(value = "password")String myPassword) throws SQLException {
        Member member1 = new Member();
        member1.setName(myName);
        member1.setEmail(myEmail);
        member1.setPassword(myPassword);
//        Member 는 class 를 new 하여 객체를 만드는 반면에 
//        MemberService 는 객체를 만들지 않고 바로 사용하고 있다. 
//        이는 MemberService 는 Component 를 통해 싱글톤으로 만들어져 있기 때문
//        싱글톤(객체를 하나를 만들어서 돌려쓴다/ 메모리를 세이브 하기 위해서) 으로 만들어진 Component 는 객체를 생성하는 것이 아니라
//        주입 (DI) 를 받아 사용
        memberService.create(member1);
        return "redirect:/";
    }

    @GetMapping("members")
    public String memberFindAll(Model model) throws SQLException {
        List<Member> members = memberService.findAll();
        model.addAttribute("memberList", members);
        return "member/member-list";
    }

    @GetMapping("member")
    public String memberFindById(@RequestParam(value = "id")Long myId, Model model) throws SQLException {
        Member member = memberService.findById(myId);
        model.addAttribute("member", member);
        return "member/member-detail";
    }

    @GetMapping("/")
    public String Home() {
        return "member/member-home";
    }

    @PostMapping("member/update")
    public String memberUpdate(@RequestParam(value = "id")String myId,
                               @RequestParam(value = "name")String myName,
                               @RequestParam(value = "email")String myEmail,
                               @RequestParam(value = "password")String myPassword) throws Exception {
        Member member1 = new Member();
        member1.setId(Long.parseLong(myId));
        member1.setName(myName);
        member1.setEmail(myEmail);
        member1.setPassword(myPassword);
        memberService.update(member1);
        return "redirect:/";
    }


}

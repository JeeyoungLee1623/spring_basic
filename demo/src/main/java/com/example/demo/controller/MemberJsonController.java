package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

// controller 앞에 따로 url 지정하면
@Controller()
public class MemberJsonController {

    @Autowired
    private MemberService memberService;

    @PostMapping("json/members/new")
    @ResponseBody
//    input 값을 form-dat 로 받는 형식
    public String memberCreate(@RequestParam(value = "name")String myName,
                               @RequestParam(value = "email")String myEmail,
                               @RequestParam(value = "password")String myPassword) throws SQLException {
        Member member1 = new Member();
        member1.setName(myName);
        member1.setEmail(myEmail);
        member1.setPassword(myPassword);
        memberService.create(member1);
        return "ok";
    }

    @GetMapping("json/members")
    @ResponseBody
        public List<Member> memberFindAll() throws SQLException {
        List<Member> members = memberService.findAll();
        return members;
    }

    @GetMapping("json/member")
    public Member memberFindById(@RequestParam(value = "id")Long myId) throws SQLException {
        Member member = memberService.findById(myId);
        return member;
    }






}


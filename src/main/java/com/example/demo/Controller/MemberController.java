package com.example.demo.Controller;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    //회원가입 많은 데이터가 넘어오니까 post방식
    @GetMapping("/members/new")
    public String createForm(){


        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberPostForm memberPostForm){
        Member member = new Member();
        member.setName(memberPostForm.getName());

        return null;
    }

    //회원목록  데이터를 넘겨받을 이유가 없다. get방식
    @GetMapping("/members")
    public String memberlist(){


        return null;
    }
}

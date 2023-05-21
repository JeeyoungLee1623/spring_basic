package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalInt;

@Service
public class MemberService {
    
//    service 에서 repository 를 주입 받기 위해서 Autowired 를 사용
    @Autowired
    private MemberRepository memberRepository;
    
    // 회원가입
    public void create(Member member){

        memberRepository.save(member);
    }

//   회원 목록 조회
//    memberRepository.findAll() 의 기본 return 타입은 List<해당 객체>
    public List<Member> findAll() {
        List<Member> members = memberRepository.findAll();
        // 아래는 찍어보기 위한 것
//        for(Member m : members){
//            System.out.println(m.getName());
//            System.out.println(m.getEmail());
//            System.out.println(m.getPassword());
//        }
        return members;
    }

    public Member findById(Long myId){
        Member members = memberRepository.findById(myId).orElse(null);
        return members;
    }



}

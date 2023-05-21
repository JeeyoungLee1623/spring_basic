package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberJdbcRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.OptionalInt;

@Service
public class MemberService {
    
//    service 에서 repository 를 주입 받기 위해서 Autowired 를 사용
//  mybatis 를 사용한 repository
//    jpa 와 함께 사용할 수도 있다. 복잡한 service logic 또는 heavy 한 쿼리가 있을 경우
//    jpa 로는 한계가 있으므로 현업에서는 mybatis 를 섞어 사용하기도 한다.
//    @Autowired
//    private MemberRepository MemberMybatisRepository;

    //    springDataJpa 를 사용한 repository
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberJdbcRepository memberjdbcRepository;
    
    // 회원가입
    public void create(Member member) throws SQLException {
        System.out.println("memberjdbcRepository test");
        memberRepository.save(member);
    }

//   회원 목록 조회
//    memberRepository.findAll() 의 기본 return 타입은 List<해당 객체>
    public List<Member> findAll() throws SQLException {
        List<Member> members = memberRepository.findAll();
        // 아래는 찍어보기 위한 것
//        for(Member m : members){
//            System.out.println(m.getName());
//            System.out.println(m.getEmail());
//            System.out.println(m.getPassword());
//        }
        return members;
    }


    public Member findById(Long myId) throws SQLException {
        Member members = memberRepository.findById(myId).orElse(null);
        return members;
    }
//    회원 수정
    public void update(Member member) throws Exception {
        Member member1 = memberRepository.findById(member.getId()).orElse(null);
        if(member1 == null){
            throw new Exception();
        }else{
            member1.setName(member.getName());
            member1.setEmail(member.getEmail());
            member1.setPassword(member.getPassword());
            memberRepository.save(member1);
        }
//        save 는 이미 존재하는 pk(id) 이 있으면 update 로 동작, id 값이 없으면 insert 로 동작
//    memberRepository.save(member);
}






}

package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


// mybatis 라는 DB Connect 기술을 쓰기 이전에는 ibatis 라는게 존재했었기에, Mapper 어노테이션은 ibatis 패키지 않에 들어있다.
@Mapper
public interface MemberMybatisRepository {
    //    JPA 와는 다르게, 사용하고자 하는 메서드를 사전에 정의해야 한다.
    void save(Member member);
        List<Member> findAll();
        Member findById(Long id);

}

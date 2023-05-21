package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// spring data jpa 의 다양한 기본기능을 쓰기 위해서는 JpaRepository 를 상속받아야 한다.
// 상속받을 때, entity 명과 해당 entity 의 pk 를 옵션으로 줘야 한다.
public interface MemberRepository extends JpaRepository<Member, Long> {
}

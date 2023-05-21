package com.example.demo.repository;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberJdbcRepository {

//    Datasource 는 DB 와 JDBC 에서 사용하는 DB 연결 드라이버.
    @Autowired
    private DataSource dataSource;

    public void save(Member member) throws SQLException {
        String sql = "insert into member(name, email, password) values(?, ?, ?)";
//        dataSource 객체 안에 DB 정볼르 담고 있고, 해당 DB 정보를 통해 connection 을 맺는다.
        Connection con = dataSource.getConnection();
//        con 객체에 작성한 쿼리문을 세팅하여 ps 객체에 할당
//        ps : DB 정보 + 쿼리문
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, member.getName());
        ps.setString(2, member.getEmail());
        ps.setString(3, member.getPassword());
//        insert 또는 update 는 executeUpdate 메서드 사용
//        select 는 executeQuery 메서드 사용
        ps.executeUpdate();
    }

    public Member findById(Long id) throws SQLException {
        String sql = "select * from member where id = ?";
//        dataSource 객체 안에 DB 정볼르 담고 있고, 해당 DB 정보를 통해 connection 을 맺는다.
        Connection con = dataSource.getConnection();
//        con 객체에 작성한 쿼리문을 세팅하여 ps 객체에 할당
//        ps : DB 정보 + 쿼리문
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            Member member = new Member();
            member.setName(rs.getString("name"));
            member.setEmail(rs.getString("email"));
            member.setPassword(rs.getString("password"));
            return member;
        }
        return null;
    }

    public List<Member> findAll() throws SQLException {
        String sql = "select * from member";
        Connection con = dataSource.getConnection();
//        con 객체에 작성한 쿼리문을 세팅하여 ps 객체에 할당
//        ps : DB 정보 + 쿼리문
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Member> memberList = new ArrayList<>();
        while(rs.next()){
            Member member = new Member();
            member.setName(rs.getString("name"));
            member.setEmail(rs.getString("email"));
            member.setPassword(rs.getString("password"));
            memberList.add(member);
        }
        return memberList;
    }






}

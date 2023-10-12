package com.sjl22951227.onlineboard.Member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sjl22951227.onlineboard.Member.Member;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    List<Member> findByMemberId(String username);
}

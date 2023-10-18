package com.sjl22951227.onlineboard.Member;

import com.sjl22951227.onlineboard.Member.repository.MemberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/members/{memberId}")
    public Member retrieveMember(@PathVariable String memberId){
        return memberRepository.findByMemberId(memberId);
    }

    @GetMapping("/members/all")
    public List<Member> retrieveAllMembers(){
        return memberRepository.findAll();
    }

    @PostMapping("/auth/signup")
    public void createMember(@RequestBody Member member){
        memberRepository.save(member);
    }
}
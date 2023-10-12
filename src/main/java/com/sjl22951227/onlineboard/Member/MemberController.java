package com.sjl22951227.onlineboard.Member;

import com.sjl22951227.onlineboard.Member.repository.MemberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/members/all")
    public List<Member> retrieveMember(){
        return memberRepository.findAll();
    }

    @PostMapping("/members/signup")
    public void createMember(@RequestBody Member member){
        memberRepository.save(member);
    }
}
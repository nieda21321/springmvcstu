package com.example.login_demo.security;

import com.example.login_demo.service.MemberService;
import com.example.login_demo.vo.MemberVO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberService memberService;

    public CustomUserDetailsService(MemberService memberService) {

        this.memberService = memberService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberVO member = memberService.selectById(username);

        System.err.println("=== loadUserByUsername ===");
        System.err.println("username: " + username);
        System.err.println("member 객체: " + member);
        System.err.println("memberPw: " + (member != null ? member.getMemberPw() : "NULL"));

        if (member == null) {

            throw new UsernameNotFoundException("User not found: " + username);
        }

        return new CustomerUserDetails(member);
    }
}

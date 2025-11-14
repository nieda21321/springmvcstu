package com.example.login_demo.security;

import com.example.login_demo.vo.MemberVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

// UserDetails 는 security에서 제공하므로 따로 인터페이스를 생성할 필요 없다
public class CustomerUserDetails implements UserDetails {

    private final MemberVO member;

    public CustomerUserDetails(MemberVO member) {

        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Collections.emptyList();
    }

    @Override
    public String getPassword() {

        return member.getMemberPw();
    }

    @Override
    public String getUsername() {

        return member.getMemberId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {

        return member.isEnabled();
    }

    // 편의 메서드
    public MemberVO getMember() {

        return member;
    }
}

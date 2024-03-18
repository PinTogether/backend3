package com.pintogether.backend.controller;

import com.pintogether.backend.auth.JwtService;
import com.pintogether.backend.customAnnotations.ThisMember;
import com.pintogether.backend.entity.Member;
import com.pintogether.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MemberRepository memberRepository;

    /**
     *
     * jwt 로 닉네임 받아보는 테스트.
     *
     */
    @GetMapping("/test")
    public Map<String, String> test(@RequestHeader(value = "Authorization") String jwt) {
        Long id = jwtService.getId(jwt);
        Map<String, String> map = new HashMap<>();
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            map.put("nickname", member.get().getNickname());
        } else {
            map.put("nickname", "AnonymousUser");
        }
        return map;
    }


    @GetMapping("/")
    public Long asdf(@ThisMember Long id) {
        return id;
    }

}

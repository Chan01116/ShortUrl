
package com.koreait.short_url_project_02.global.rq.Rq;

import com.koreait.short_url_project_02.domain.member.member.entity.Member;
import com.koreait.short_url_project_02.domain.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@RequiredArgsConstructor
public class Rq {

    private final MemberService memberService;

    public Member getMember() {
        return memberService.getReferenceById(1L);
    }
}

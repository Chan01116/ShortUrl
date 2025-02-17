
package com.koreait.short_url_project_02.global.initData;

import com.koreait.short_url_project_02.domain.article.article.entity.Article;
import com.koreait.short_url_project_02.domain.article.article.service.ArticleService;
import com.koreait.short_url_project_02.domain.member.member.entity.Member;
import com.koreait.short_url_project_02.domain.member.member.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

//!prod == dev or test

@Configuration
@RequiredArgsConstructor
@Slf4j
public class All {
    // this를 통한 객체 내부에서의 메서드 호출은 @Transactional을 작동시키지 않아
    // 외부객체에 의한 메서드 호출은 @Transactional이 작동해
    // @Lazy, @Autowired 조합은 this의 외부 호출 모드 버전의 self 를 얻을 수 있어
    // self를 통한 메서드 호출은 @Transactional을 작동시킬 수 있어

    @Lazy
    @Autowired
    private All self;

    private final ArticleService articleService;
    private final MemberService memberService;

    @Bean // 개발자가 new 하지 않아도 스프링부트가 직접 관리하는 객체
    public ApplicationRunner initDataProd() {
        return args -> {
            self.work1();
        };
    }

    @Transactional
    public void work1() {
        log.debug("initAll start");

        Member member1 = memberService.join("user1", "1234", "유저 1").getData();
        Member member2 = memberService.join("user2", "1234", "유저 2").getData();


        Article article1 = articleService.write(member1,"제목 1", "내용 1").getData();
        Article article2 = articleService.write(member1,"제목 2", "내용 2").getData();
        Article article3 = articleService.write(member2,"제목 3", "내용 3").getData();
        Article article4 = articleService.write(member2,"제목 4", "내용 4").getData();

        article2.setTitle("제목 2-2");

        articleService.delete(article1);

    }

}

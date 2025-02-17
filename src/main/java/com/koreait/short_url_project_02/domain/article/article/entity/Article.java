package com.koreait.short_url_project_02.domain.article.article.entity;

import com.koreait.short_url_project_02.domain.member.member.entity.Member;
import com.koreait.short_url_project_02.global.jpa.entity.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class Article extends BaseTime {
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    private Member author;
}
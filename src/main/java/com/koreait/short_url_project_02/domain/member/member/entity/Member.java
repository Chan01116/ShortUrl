package com.koreait.short_url_project_02.domain.member.member.entity;

import com.koreait.short_url_project_02.global.jpa.entity.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
public class Member  extends BaseTime {
    @Column(unique = true)
    private String username;
    private String password;
    private String nickname;
}
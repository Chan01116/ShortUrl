package com.koreait.short_url_project_02;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Article {
    @GeneratedValue(strategy = IDENTITY)
    @Id
    private long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;

}

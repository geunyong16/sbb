package com.mysite.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id; //고유번호

    @Column(length = 200)
    private String subject; //제목

    @Column(columnDefinition = "TEXT")
    private String content; //내용

    private LocalDateTime createDate; //작성 일시
}

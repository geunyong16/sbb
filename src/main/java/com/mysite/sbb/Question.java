package com.mysite.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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

    private LocalDateTime creatDate;

    @OneToMany(mappedBy = "question",cascade = CascadeType.REMOVE)
    private List<Answer> anserList; //작성 일시, create_date라는 열의 이름을 만듦
}

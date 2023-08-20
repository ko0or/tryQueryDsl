package com.example.tryquerydsl.examEM;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "exam")
@Getter @Setter @ToString
public class ExamEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    public void update(ExamDTO dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }
}

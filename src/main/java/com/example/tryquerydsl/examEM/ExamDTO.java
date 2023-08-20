package com.example.tryquerydsl.examEM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExamDTO {

    private Long id;
    private String title;
    private String content;

    public ExamEntity toEntity() {
        ExamEntity newEntity = new ExamEntity();
        newEntity.setTitle(this.title);
        newEntity.setContent(this.content);
        return newEntity;
    }
}

package com.example.tryquerydsl.examQueryDSL;

import com.example.tryquerydsl.examEM.ExamDTO;
import com.example.tryquerydsl.examEM.ExamEntity;
import com.example.tryquerydsl.examEM.QExamEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dsl")
public class QuerydslController {
    @Autowired EntityManager em;
    private JPAQueryFactory query;

    @GetMapping("/list")
    public List<ExamEntity> list() {
        query = new JPAQueryFactory(em);
        return query.selectFrom( QExamEntity.examEntity ).fetch();
    }

    @PostMapping("/create") @Transactional
    public String create(@RequestBody ExamDTO dto) {
        em.persist(dto.toEntity());
        return "create";
    }
    @GetMapping("/read")
    public String read(long id) {
//         return em.find(ExamEntity.class, id).toString();
        query = new JPAQueryFactory(em);
        QExamEntity q = new QExamEntity("hello");
        return query.selectFrom(q).where(q.id.eq(id)).fetchOne().toString();
    }

    @PatchMapping("/update") @Transactional
    public String update(@RequestBody ExamDTO dto) {
//        ExamEntity entity = em.find(ExamEntity.class, dto.getId());
//        entity.update(dto);

        query = new JPAQueryFactory(em);
        QExamEntity q = new QExamEntity("hello");
        query.update(q)
                .set(q.title, dto.getTitle())
                .set(q.content, dto.getContent())
                .where(q.id.eq(dto.getId()))
                .execute();

        return "update";
    }

    @DeleteMapping("/delete") @Transactional
    public String delete(long id) {
        query = new JPAQueryFactory(em);
        QExamEntity q = new QExamEntity("hello");

        query.delete(q).where(q.id.eq(id)).execute();
        return "delete";
    }

}


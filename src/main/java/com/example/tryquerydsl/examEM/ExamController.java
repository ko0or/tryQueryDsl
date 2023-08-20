package com.example.tryquerydsl.examEM;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/em")
public class ExamController {
    @Autowired EntityManager em;


    @GetMapping("/list")
    public List<ExamEntity> list() {
        JPAQueryFactory query = new JPAQueryFactory(em);
        return query.selectFrom( QExamEntity.examEntity ).fetch();
    }

    @PostMapping("/create") @Transactional
    public String create(@RequestBody ExamDTO dto) {
        em.persist(dto.toEntity());
        return "create";
    }
    @GetMapping("/read")
    public String read(int id) {
        return em.find(ExamEntity.class, id).toString();
    }

    @PatchMapping("/update") @Transactional
    public String update(@RequestBody ExamDTO dto) {
        ExamEntity entity = em.find(ExamEntity.class, dto.getId());
        entity.update(dto);
        return "update";
    }

    @DeleteMapping("/delete") @Transactional
    public String delete(int id) {
        em.remove( em.find(ExamEntity.class, id) );
        return "delete";
    }

}

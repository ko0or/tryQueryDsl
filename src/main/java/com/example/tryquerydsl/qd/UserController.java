package com.example.tryquerydsl.qd;

import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
//import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
/* @ */import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Transactional
public class UserController {
    @Autowired EntityManager em;


    @GetMapping("/")
    public String dslTest() {
//    public UserEntity dslTest() {


        // 저장하기위한 엔티티 생성
        UserEntity originalEntity = new UserEntity();
        originalEntity.setName("context test");
        originalEntity.setPwd("test1234");
        // 영속성 컨테이너에 넣었다가
        em.persist(originalEntity);
        // 다시 빼보기
        em.clear();

        // selectFrom(Q클래스)를 통해서 , fetch() 모든 조회결과를 가져옴
        JPQLQueryFactory query = new JPAQueryFactory(em);
//        QUserEntity q = new QUserEntity("test");
//        List<UserEntity> result = query.selectFrom( q ).fetch();
//        log.info("@@## result => " + result );

        /*
            #. JPQL

            기본  : SELECT * FROM 테이블명 WHERE 컬럼명 = 14
            JPQL :
                SELECT
                    u
                FROM
                    user u
                WHERE
                    u.id = 14

         */


        // ★ 단건 조회 (쿼리팩토리)
//        UserEntity result = query.select(q).from(q)
//                                 .where(q.id.eq(100))
//                                 .fetchOne();


        // ☆ 저장 (엔티티매니저)
        // em.persist(originalEntity);
        // ★ 저장 (쿼리팩토리)



        // ★ 변경 (쿼리팩토리)
        // long result = query.update(q).set(q.name, "newUserName#").where(q.id.eq(15)).execute();
        // ★ 삭제 (쿼리팩토리)
        // long result = query.delete(q).where(q.id.between(17, 23)).execute();


        // ☆ 변경 (엔티티매니저)
        // UserEntity result = em.find(UserEntity.class, 16);
        // result.setName("엔티티로 바로 수정?");
        // ☆ 삭제 (엔티티매니저)
        // UserEntity result = em.find(UserEntity.class, 16);
        // em.remove(result);



        return "#";

//        return result;
    }


}

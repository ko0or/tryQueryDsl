package com.example.tryquerydsl;

import com.example.tryquerydsl.qd.QUserEntity;
import com.example.tryquerydsl.qd.UserEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class TryQueryDslApplicationTests {

    @Autowired EntityManager em;

    @Test
    void contextLoads() {

        UserEntity user = new UserEntity();
        em.persist(user);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QUserEntity qEntity = new QUserEntity("h");

        UserEntity result = query
                .selectFrom(qEntity)
                .fetchOne();

        Assertions.assertThat(result).isEqualTo(user);

        Assertions.assertThat(
                result.getId()
        ).isEqualTo(user.getId());

    }

}

package com.example.daedongv3_5.domain.teacher.repository;


import com.example.daedongv3_5.domain.teacher.domain.TeacherEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeacherRepository extends CrudRepository<TeacherEntity, Long> {

    Optional<TeacherEntity> findByAccountId(String accountId);
    Boolean existsByAccountId(String accountId);

}

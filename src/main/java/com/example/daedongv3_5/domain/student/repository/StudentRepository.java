package com.example.daedongv3_5.domain.student.repository;

import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

    Optional<StudentEntity> findByAccountId(String accountId);
    Boolean existsByAccountId(String accountId);

}

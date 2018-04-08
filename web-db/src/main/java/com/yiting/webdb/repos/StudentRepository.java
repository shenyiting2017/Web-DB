package com.yiting.webdb.repos;

import org.springframework.data.repository.CrudRepository;

import com.yiting.webdb.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}

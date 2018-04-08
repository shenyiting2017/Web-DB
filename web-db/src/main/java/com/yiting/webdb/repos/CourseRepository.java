package com.yiting.webdb.repos;

import org.springframework.data.repository.CrudRepository;

import com.yiting.webdb.models.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}

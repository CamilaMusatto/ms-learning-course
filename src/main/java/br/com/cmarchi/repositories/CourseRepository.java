package br.com.cmarchi.repositories;

import br.com.cmarchi.domain.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CourseRepository extends MongoRepository<Course, UUID> {

    Course findByCourseName(String courseName);
}

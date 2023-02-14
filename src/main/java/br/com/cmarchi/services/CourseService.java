package br.com.cmarchi.services;

import br.com.cmarchi.domain.Course;
import br.com.cmarchi.exceptions.InvalidParameterException;
import br.com.cmarchi.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;


    public Course createCourseResult(String courseName){

        if (isValid(courseName)) {
            Course course = new Course(courseName);
            return repository.save(course);

        } else {
            throw new InvalidParameterException("Invalid parameter!");
        }
    }


    public List<Course> searchCourse(UUID courseId){

        Optional<Course> course = repository.findById(courseId);

        if(course.isPresent()){
            return List.of(course.get());
        }else {
            return repository.findAll();
        }



    }


    private boolean courseNameExists(String courseName){
        Course course = repository.findByCourseName(courseName);

        if(course == null){
            return true;
        } else{
            return false;
        }

    }

    private boolean checkLength(String courseName){
        if(courseName.length() > 3){
            return true;
        } else{
            return false;
        }
    }

    private boolean isValid(String courseName){
         if (courseNameExists(courseName) && checkLength(courseName)){
             return true;
         } else{
             return false;
         }
    }
}

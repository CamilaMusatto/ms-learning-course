package br.com.cmarchi.services;

import br.com.cmarchi.domain.Course;
import br.com.cmarchi.exceptions.InvalidParameterException;
import br.com.cmarchi.model.request.CourseRequestDto;
import br.com.cmarchi.model.response.CourseResponseDto;
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


    public CourseResponseDto createCourseResult(CourseRequestDto requestDto){

        if (isValid(requestDto)) {
            Course course = repository.save(new Course(requestDto.getCourseName()));
            return new CourseResponseDto(course.getCourseId());

        } else {
            throw new InvalidParameterException("Invalid parameter!");
        }
    }


    public List<Course> searchCourse(UUID courseId){

        Optional<Course> course = repository.findByCourseId(courseId);

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

    private boolean isValid(CourseRequestDto requestDto){
         if (courseNameExists(requestDto.getCourseName()) && checkLength(requestDto.getCourseName())){
             return true;
         } else{
             return false;
         }
    }
}

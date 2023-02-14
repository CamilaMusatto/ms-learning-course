package br.com.cmarchi.controllers;

import br.com.cmarchi.domain.Course;
import br.com.cmarchi.exceptions.InvalidParameterException;
import br.com.cmarchi.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.UUID;

@Tag(name = "Course" , description = "Endpoints for managing courses")
@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private CourseService service;

    @Operation(summary = "Search a course by id", description = "Get a course by id",
    tags = {"Course"},
    responses = {
            @ApiResponse(description = "Sucess", responseCode = "200", content = {
                    @Content ( mediaType = "application/json",
                            schema = @Schema(implementation = Course.class))
            }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
    })
    @GetMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Course>> searchCourses(@Parameter(description = "id of course to be searched")
                                                          @RequestParam(value = "courseId", required = false,
                                                                  defaultValue = "00000000-0000-0000-0000-000000000000") UUID courseId){

        return ResponseEntity.ok(service.searchCourse(courseId));
    }

    @Operation(summary = "Create a course", description = "Create a new course", tags = {"Course"},
    responses = {
            @ApiResponse(description = "Course created", responseCode = "201",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UUID.class))
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Invalid Parameter" , responseCode = "500", content = @Content)

    })
    @PostMapping(value = "/course", consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<UUID> createCoursesResult(@RequestBody Course course){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCourseResult(course.getCourseName()).getCourseId());
    }




}

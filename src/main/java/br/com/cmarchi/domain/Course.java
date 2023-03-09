package br.com.cmarchi.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class Course {

    @Id
    private String id;
    private UUID courseId;
    private String courseName;
    private boolean status;

    @CreatedDate
    private LocalDateTime createdOn;

    public Course(){

    }

    public Course(String courseName) {
        this.courseId = UUID.randomUUID();
        this.courseName = courseName;
        this.status = true;
        this.createdOn = LocalDateTime.now();

    }

    public String getId() {
        return id;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean isStatus() {
        return status;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
}

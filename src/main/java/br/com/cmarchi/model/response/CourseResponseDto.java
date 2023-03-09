package br.com.cmarchi.model.response;

import java.util.UUID;

public class CourseResponseDto {

    private UUID courseId;

    public CourseResponseDto() {
    }

    public CourseResponseDto(UUID courseId) {
        this.courseId = courseId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }
}

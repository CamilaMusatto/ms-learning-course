package br.com.cmarchi.model.request;

public class CourseRequestDto {

    private String courseName;

    public CourseRequestDto() {
    }

    public CourseRequestDto(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

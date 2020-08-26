package lms.backend.domain;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Where(clause = "deleted = 'false'")
public class CourseAttending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    private CourseRealization courseRealization;

    private int grade;

    public CourseAttending() {
    }



    public CourseAttending(Long id, Student student,
                           CourseRealization courseRealization, int grade) {
        this.id = id;
        this.student = student;
        this.courseRealization = courseRealization;
        this.grade = grade;
    }



    public int getGrade() {
        return grade;
    }



    public void setGrade(int grade) {
        this.grade = grade;
    }



    public CourseRealization getCourseRealization() {
        return courseRealization;
    }

    public void setCourseRealization(CourseRealization courseRealization) {
        this.courseRealization = courseRealization;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public CourseAttendingDTO toDTO()
//    {
//        return new CourseAttendingDTO(this.id, this.getStudent().getId(), this.courseRealization.getId());
//    }
}

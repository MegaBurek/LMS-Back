package lms.backend.domain;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Where(clause = "deleted = 'false'")
public class CourseTeaching {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tutor tutor;

    @ManyToOne(fetch = FetchType.LAZY)
    private CourseRealization courseRealization;

    public CourseTeaching() {
    }

    public CourseTeaching(Long id, Tutor tutor, CourseRealization courseRealization) {
        this.id = id;
        this.tutor = tutor;
        this.courseRealization = courseRealization;
    }

    public CourseRealization getCourseRealization() {
        return courseRealization;
    }

    public void setCourseRealization(CourseRealization courseRealization) {
        this.courseRealization = courseRealization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public CourseTeachingDTO toDTO()
//    {
//        return new CourseTeachingDTO(this.id, this.numberOfClasses, this.getTutor().getId(), this.courseRealization.toDTO());
//    }

}

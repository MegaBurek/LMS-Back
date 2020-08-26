package lms.backend.domain;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Where(clause = "deleted = 'false'")
public class StudentYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfYear;

    @OneToMany(mappedBy = "studentYear", fetch = FetchType.LAZY)
    private Set<Course> courses;

    @ManyToOne(cascade = CascadeType.ALL)
    private StudyProgram studyProgram;

    public StudentYear() {
    }


    public StudentYear(Long id, int numberOfYear, Set<Course> courses) {
        this.id = id;
        this.numberOfYear = numberOfYear;
        this.courses = courses;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfYear() {
        return numberOfYear;
    }

    public void setNumberOfYear(int numberOfYear) {
        this.numberOfYear = numberOfYear;
    }
}

package lms.backend.domain;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Where(clause = "deleted = 'false'")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    private String title;

    private int ects;

    private boolean obligatory;

    @Size(max = 640)
    private String description;

    private int numberOfLectures;

    private int numberOfExercises;

    @ManyToOne
    private StudentYear studentYear;

    public Course() {
    }

    public Course(Long id, @Size(max = 50) String title, int ects, boolean obligatory, @Size(max = 640) String description, int numberOfLectures, int numberOfExercises, StudentYear studentYear) {
        this.id = id;
        this.title = title;
        this.ects = ects;
        this.obligatory = obligatory;
        this.description = description;
        this.numberOfLectures = numberOfLectures;
        this.numberOfExercises = numberOfExercises;
        this.studentYear = studentYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public boolean isObligatory() {
        return obligatory;
    }

    public void setObligatory(boolean obligatory) {
        this.obligatory = obligatory;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfLectures() {
        return numberOfLectures;
    }

    public void setNumberOfLectures(int numberOfLectures) {
        this.numberOfLectures = numberOfLectures;
    }

    public int getNumberOfExcercises() {
        return numberOfExercises;
    }

    public void setNumberOfExcercises(int numberOfExcercises) {
        this.numberOfExercises = numberOfExcercises;
    }

    public StudentYear getStudyProgram() {
        return studentYear;
    }

    public void setStudyProgram(StudentYear studentYear) {
        this.studentYear = studentYear;
    }

    //    public CourseDTO toDTO()
//    {
//        return new CourseDTO(this.id, this.title, this.ects, this.obligatory, this.numberOfLectures, this.numberOfExercises);
//    }

}

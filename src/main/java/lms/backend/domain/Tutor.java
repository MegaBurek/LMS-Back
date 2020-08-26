package lms.backend.domain;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Where(clause = "deleted = 'false'")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 20)
    private String personalIdentificationNumber;

    @OneToMany(mappedBy = "tutor", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<CourseTeaching> courseTeachings;

    @OneToOne
    private User user;

    public Tutor() {
    }

    public Tutor(Long id, @Size(max = 20) String personalIdentificationNumber, User user) {
        this.id = id;
        this.personalIdentificationNumber = personalIdentificationNumber;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }

    public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<CourseTeaching> getCourseTeachings() {
        return courseTeachings;
    }

    public void setCourseTeachings(Set<CourseTeaching> courseTeachings) {
        this.courseTeachings = courseTeachings;
    }

    //    public TutorDTO toDTO() {
//        return new TutorDTO(this.id, this.firstName, this.lastName, this.personalIdentificationNumber, this.user.toDTO());
//    }

}

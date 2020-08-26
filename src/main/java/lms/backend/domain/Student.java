package lms.backend.domain;

import org.hibernate.annotations.Where;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import javax.persistence.*;

@Entity
@Where(clause = "deleted = 'false'")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 7)
    private String index;

    @OneToOne
    private User user;

    public Student() {
    }

    public Student(Long id, @Size(max = 7) String index, User user) {
        this.id = id;
        this.index = index;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getindex() {
        return index;
    }

    public void setindex(String index) {
        this.index = index;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


//    public StudentDTO toDTO() {
//        Set<CourseAttendingDTO> sy = new HashSet<>();
//        if (!(this.courseAttendings == null))
//            for (CourseAttending s : this.courseAttendings)
//                sy.add(s.toDTO());
//
//        Set<StudentYearDTO> sy1 = new HashSet<>();
//        if (!(this.studentYears == null))
//            for (StudentYear s1 : this.studentYears)
//                sy1.add(s1.toDTO());
//
//        return new StudentDTO(this.id, this.firstName, this.lastName, this.user.toDTO(), this.index, sy, sy1);
//    }

}

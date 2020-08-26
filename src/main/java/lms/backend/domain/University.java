package lms.backend.domain;

import org.apache.tomcat.jni.Address;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Where(clause = "deleted = 'false'")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    private String name;

    private LocalDate yearOfEstablishment;

    @OneToMany(mappedBy = "university")
    private Set<Faculty> faculties;

    @OneToOne(fetch = FetchType.LAZY)
    private Tutor dean;

    public University() {
    }

    public University(Long id, @Size(max = 50) String name, LocalDate yearOfEstablishment, Set<Faculty> faculties, Tutor dean) {
        this.id = id;
        this.name = name;
        this.yearOfEstablishment = yearOfEstablishment;
        this.faculties = faculties;
        this.dean = dean;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    public Tutor getDean() {
        return dean;
    }

    public void setDean(Tutor dean) {
        this.dean = dean;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(LocalDate yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }

}
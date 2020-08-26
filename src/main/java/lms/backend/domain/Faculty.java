package lms.backend.domain;

import org.apache.tomcat.jni.Address;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Where(clause = "deleted = 'false'")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    private String name;

    @Version
    private int version = 0;

    @ManyToOne(cascade = CascadeType.ALL)
    private University university;

    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<StudyProgram> studyPrograms;

    @OneToOne(fetch = FetchType.LAZY)
    private Tutor tutor;


    public Faculty() {
    }


    public Faculty(Long id, @Size(max = 50) String name, University university,
                   Set<StudyProgram> studyPrograms, Tutor tutor) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.university = university;
        this.studyPrograms = studyPrograms;
        this.tutor = tutor;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Set<StudyProgram> getStudyPrograms() {
        return studyPrograms;
    }

    public void setStudyPrograms(Set<StudyProgram> studyPrograms) {
        this.studyPrograms = studyPrograms;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    //    public FacultyDTO toDTO()
//    {
//        return new FacultyDTO(this.name, this.dekan.toDTO());
//    }

}

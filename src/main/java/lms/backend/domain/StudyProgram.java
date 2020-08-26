package lms.backend.domain;


import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Where(clause = "deleted = 'false'")
public class StudyProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Tutor tutor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Faculty faculty;

    @OneToMany(mappedBy = "studyProgram")
    private Set<StudentYear> studentYears;

    public StudyProgram() {}

    public StudyProgram(Long id, @Size(max = 50) String name, Tutor tutor, Faculty faculty, Set<StudentYear> studentYears) {
        this.id = id;
        this.name = name;
        this.tutor = tutor;
        this.faculty = faculty;
        this.studentYears = studentYears;
    }

    //	public StudyProgram(MultipartFile file, String name2, Center c) {
//		this.pic_name = file.getName();
//		this.mimetype = file.getContentType();
//		try {
//		this.pic = file.getBytes();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		this.name = name2;
//		this.center = c;
//	}


    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Set<StudentYear> getStudentYears() {
        return studentYears;
    }

    public void setStudentYears(Set<StudentYear> studentYears) {
        this.studentYears = studentYears;
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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

//    public StudyProgramDTO toDTO()
//    {
//        Set<YearOfStudyDTO> ret = new HashSet<>();
//        for(YearOfStudy yos: this.yearsOfStudy)
//            ret.add(yos.toDTO());
//
//
//        return new StudyProgramDTO(this.id, this.name, ret);
//    }
    
}

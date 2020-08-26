package lms.backend.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lms.backend.dto.UserDTO;
import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lms.backend.domain.Student;
import lms.backend.domain.Tutor;
import lms.backend.domain.Admin;

@Entity
@Where(clause = "deleted = 'false'")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 128, nullable = false)
    private String surname;

    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserPermission> userPermissions;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Student student;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Tutor tutor;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Admin admin;


    public User() {

    }

    public User(Long id, String username, String password, String name, String surname, String role, Set<UserPermission> userPermissions, Student student, Tutor tutor, Admin admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.userPermissions = userPermissions;
        this.student = student;
        this.tutor = tutor;
        this.admin = admin;
    }

    //for registering user
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserPermission> getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(Set<UserPermission> userPermissions) {
        this.userPermissions = userPermissions;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor Tutor) {
        this.tutor = tutor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    //    public UserDTO toDTO() {
//        Set<UserPermissionDTO> sy = new HashSet<>();
//        for (UserPermission s : this.userPermissions)
//            sy.add(s.toDTO());
//
//        return new UserDTO(this.id, this.username, this.password, this.role, sy);
//    }


}

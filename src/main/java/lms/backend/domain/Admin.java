package lms.backend.domain;

import javax.persistence.*;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private String note;


    public Admin(Long id, String firstname, String lastname, User user, String note) {
        this.id = id;
        this.user = user;
        this.note = note;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }



    public String getNote() {
        return note;
    }


    public void setNote(String note) {
        this.note = note;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public Admin() {
    }


//    public AdminDTO toDTO() {
//        return new AdminDTO(this.firstName, this.lastName, this.user.toDTO());
//
//    }
}

package spring.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PERSON")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_user")
    private int id;

    @Column(name="_name")
    private String name;

    @Column(name="_email")
    private String email;

    @Column(name="rol")
    private String rol;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Exam> exams = new ArrayList();
    
}









package spring.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import utils.AuthorityName;


@Entity
@Table(name="Autorities")
public class Authority {

  
    public Authority() {
    }


    public Authority(AuthorityName name) {
        this.name = name;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_auto")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name="name_auto")
    private AuthorityName name;
}







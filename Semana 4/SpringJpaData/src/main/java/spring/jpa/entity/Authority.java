package spring.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import utils.AuthorityName;


@Entity
@Table(name="Autorities")
public class Authority {

    // Constructor vacío (necesario para Hibernate)
    public Authority() {
    }

    // Constructor para inicializar con el nombre de la autoridad
    public Authority(AuthorityName name) {
        this.name = name;
    }
    
    // Getters y Setters
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







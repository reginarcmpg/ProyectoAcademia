package spring.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import utils.AuthorityName;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Autorities")
public class Authority {

	 public Authority(AuthorityName name) {
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









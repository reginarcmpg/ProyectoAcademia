package spring.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EXAM")
public class Exam {
   
    @Column(name="Id_Examen")  // Mapea con la columna Id_Examen de la tabla
    private int id;

    @Column(name="Id_Student")  // Mapea con la columna Id_Student de la tabla
    private int studentId;

    @Column(name="Type_exam")  // Mapea con la columna Type_exam de la tabla
    private String type;

    @Column(name="Grade")  // Mapea con la columna Grade de la tabla
    private float grade;

    @Column(name="Add_Info")  // Mapea con la columna Add_Info de la tabla
    private String info;
    
}









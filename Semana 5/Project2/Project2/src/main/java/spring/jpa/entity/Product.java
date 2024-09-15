package spring.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int ID;

    @Column(name="MAKEUP")
    private String MAKEUP;

    @Column(name="PRICE")
    private double PRICE;

    @Column(name="CATEGORY")
    private String CATEGORY;
    
    @Column(name="STOCK")
    private int STOCK;
    
  
}









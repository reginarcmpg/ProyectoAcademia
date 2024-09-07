package com.javatechie.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class bookEntity {

    @Id
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "year")
    private int year;
    @Column(name = "category")
    private String category;
    @Column(name = "languaje")
    private String languaje;
    @Column(name = "originCountry")
    private String originCountry;
   
  

}

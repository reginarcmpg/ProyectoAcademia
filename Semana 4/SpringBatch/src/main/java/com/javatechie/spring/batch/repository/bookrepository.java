package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.bookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookrepository  extends JpaRepository<bookEntity,Integer> {

}

package com.spring.bookManagementSystem.repository.service;

import com.spring.bookManagementSystem.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Books,Integer> {

}

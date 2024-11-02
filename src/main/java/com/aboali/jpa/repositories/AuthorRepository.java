package com.aboali.jpa.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aboali.jpa.models.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
//    NamedQuery
    @Modifying
    @Transactional
    void  updateByNamedQuery(@Param("age") int age);
    List<Author> findByAgeRange(@Param("age") int age);

    //if i want to update author a to set a.age to 20 where a.id=1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

//    to update all the ages of the authors
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorsByAge(int age);

    // select * from author where first_name = 'ali'
    List<Author> findAllByFirstName(String fn);
    // select * from author where first_name = 'al'
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    // select * from author where first_name like '%al%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    // select * from author where first_name like 'al%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    // select * from author where first_name like '%al'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);
    // select * from author where first_name in ('ali', 'bou', 'coding')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);

}
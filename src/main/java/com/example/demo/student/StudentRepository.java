package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/* data link layer interface
* i was using postgres database running locally*/
@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long > {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
        Optional<Student> findStudentByEmail(String email);

}

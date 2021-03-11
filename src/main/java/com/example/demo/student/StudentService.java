package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        //check if email already exists in database
        if(studentOptional.isPresent())
            //if exists then throw illegalStateException
            throw new IllegalStateException("Email is being used by somebody else");
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        //Check if id exists in db
        if (!exist)
            //throw illegalStateExpection if exists
            throw new IllegalStateException("student with id "+ studentId+" does not exists");
        studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        //check that the student we wanna update exists
        Student student = studentRepository.findById(studentId).orElseThrow(()
                -> new IllegalStateException("student with id "+ studentId+" does not exists"));
        //check if in PUT request name has been given
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name))
            student.setName (name);
        //check if in PUT request email has been given
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            //check if email already exists
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }

    }
}


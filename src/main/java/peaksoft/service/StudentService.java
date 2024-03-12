package peaksoft.service;

import peaksoft.model.Student;

import java.util.List;

public interface StudentService {
    void createStudentTable();
    String saveStudent(Student newStudent);
    Student findById(Long id);
    List<Student> findAll();
    boolean updateStudentById(Student student, Long id);
    String deleteById(Long id);

}

package peaksoft.dao;

import peaksoft.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    void createStudentTable();
    boolean saveStudent(Student newStudent);
    Optional<Student> findById(Long id);
    List<Student> findAll();
    boolean updateStudentById(Student student, Long id);
    boolean deleteById(Long id);
}

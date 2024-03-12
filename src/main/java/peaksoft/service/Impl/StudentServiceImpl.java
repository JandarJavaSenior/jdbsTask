package peaksoft.service.Impl;

import peaksoft.dao.StudentDao;
import peaksoft.dao.impl.StudentDaoImpl;
import peaksoft.model.Student;
import peaksoft.service.StudentService;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao = new StudentDaoImpl();
    @Override
    public void createStudentTable() {
        studentDao.createStudentTable();
    }

    @Override
    public String saveStudent(Student newStudent) {
        boolean b = studentDao.saveStudent(newStudent);
        return b ? "Saktaldu":"Saktalgan Jok";
    }

    @Override
    public Student findById(Long id) {
        return studentDao.findById(id).orElseThrow(()->new RuntimeException("BUl id Student jok"));
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public boolean updateStudentById(Student student, Long id) {
        return false;
    }

    @Override
    public String deleteById(Long id) {
        return null;
    }
}

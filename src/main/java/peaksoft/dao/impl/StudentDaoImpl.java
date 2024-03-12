package peaksoft.dao.impl;

import peaksoft.config.JBDConfig;
import peaksoft.dao.StudentDao;
import peaksoft.model.Student;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class StudentDaoImpl implements StudentDao {

    private final Connection connection = JBDConfig.getConnection();

    @Override
    public void createStudentTable() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("""
                                        create table students(
                                        id serial primary key ,
                                        full_name varchar,
                                        email varchar,
                                        date_of_birth date
                                        );  
                                        """);
            statement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean saveStudent(Student newStudent) {

        String query = """
                          insert into students(full_name,email,date_of_birth)
                          values (?,?,?);
                          """;
        int exe = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1,newStudent.getFullName());
            preparedStatement.setString(2,newStudent.getEmail());
            preparedStatement.setDate(3, Date.valueOf(newStudent.getDateOfBirth()));
            exe = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return exe != 0;
    }

    @Override
    public Optional<Student> findById(Long id) {
        Student student = new Student();
        String query = "select * from students where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1,id);
            ResultSet   resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                throw new RuntimeException(id+" id ne naiden");
            }
            student.setId(resultSet.getLong("id"));
            student.setFullName(resultSet.getString("full_name"));
            student.setEmail(resultSet.getString("email"));
            student.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(student);
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
    public boolean deleteById(Long id) {
        return false;
    }
}

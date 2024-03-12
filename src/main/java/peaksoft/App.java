package peaksoft;

import peaksoft.model.Student;
import peaksoft.service.Impl.StudentServiceImpl;
import peaksoft.service.StudentService;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentService service = new StudentServiceImpl();
        //service.createStudentTable();
//        System.out.println(service.saveStudent(new Student(
//                "Jandar",
//                "jandar@gmail.com",
//                LocalDate.of(1997,5,12))));
        try {
            System.out.println(service.findById(3L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

package guru.springframework.services;

import guru.springframework.commands.StudentForm;
import guru.springframework.domain.Student;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface StudentService {

    List<Student> listAll();

    Student getById(Long id);

    Student saveOrUpdate(Student student);

    void delete(Long id);

    Student saveOrUpdateStudentForm(StudentForm studentForm);
}
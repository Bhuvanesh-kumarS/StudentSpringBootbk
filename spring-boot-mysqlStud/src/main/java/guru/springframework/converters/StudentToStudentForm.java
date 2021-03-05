package guru.springframework.converters;

import guru.springframework.commands.StudentForm;
import guru.springframework.domain.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Bhuvaneshkumar on 1/10/17.
 */
@Component
public class StudentToStudentForm implements Converter<Student, StudentForm> {
    @Override
    public StudentForm convert(Student student) {
    	StudentForm studentForm = new StudentForm();
    	studentForm.setRollNo(student.getRollNo());
        studentForm.setName(student.getName());
        studentForm.setEmail(student.getEmail());
        studentForm.setPassword(student.getPassword());
        studentForm.setCreatedDate(student.getCreatedDate());
        studentForm.setLastLoginDate(student.getLastLoginDate());
        return studentForm;
    }
}
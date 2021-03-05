package guru.springframework.converters;

import guru.springframework.commands.StudentForm;
import guru.springframework.domain.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by Bhuveneshkumar on 1/10/17.
 */
@Component
public class StudentFormToStudent implements Converter<StudentForm, Student> {

    @Override
    public Student convert(StudentForm studentForm) {
    	Student student = new Student();
        if (studentForm.getId() != null  && !StringUtils.isEmpty(studentForm.getId())) {
        	student.setId(new Long(studentForm.getId()));
        }
        student.setRollNo(studentForm.getRollNo());
        student.setName(studentForm.getName());
        student.setEmail(studentForm.getEmail());
        student.setPassword(studentForm.getPassword());
        student.setCreatedDate(studentForm.getCreatedDate());
        student.setLastLoginDate(studentForm.getLastLoginDate());
        return student;
    }
}


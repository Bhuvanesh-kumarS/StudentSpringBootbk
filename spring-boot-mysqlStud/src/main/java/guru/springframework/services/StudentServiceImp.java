package guru.springframework.services;

import guru.springframework.commands.StudentForm;
import guru.springframework.converters.StudentFormToStudent;
import guru.springframework.domain.Student;
import guru.springframework.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class StudentServiceImp implements StudentService {

    private StudentRepository studentRepository;
    private StudentFormToStudent studentFormTostudent;

    @Autowired
    public StudentServiceImp(StudentRepository studentRepository, StudentFormToStudent studentFormToStudent) {
        this.studentRepository = studentRepository;
        this.studentFormTostudent = studentFormToStudent;
    }


    @Override
    public List listAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add); //fun with Java 8
        return students;
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveOrUpdate(Student student) {
    	studentRepository.save(student);
        return student;    //Employee savedEmployee = employeeService.saveOrUpdateEmployeeForm(employeeForm)
    }

    @Override
    public void delete(Long id) {
    	studentRepository.deleteById(id);

    }

    @Override
    public Student saveOrUpdateStudentForm(StudentForm studentForm) {
    	Student savedStudent = saveOrUpdate(studentFormTostudent.convert(studentForm));

        System.out.println("Saved Student Id: " + savedStudent.getId());
        return savedStudent;
    }
}


package guru.springframework.controllers;

import guru.springframework.commands.StudentForm;
import guru.springframework.converters.StudentToStudentForm;
import guru.springframework.domain.Student;
import guru.springframework.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import javax.validation.Valid;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class StudentJController {
    private StudentService studentService;

    
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/all")
    public String redirToList(){
        return "redirect:/jstudent/listjson";
    }

    @RequestMapping("/jstudent/listjson")
    public ResponseEntity<List<Student>> listJStudent(){
        return ResponseEntity.ok(studentService.listAll());
    }


    @RequestMapping("/jstudent/show/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id){
        return ResponseEntity.ok(studentService.getById(Long.valueOf(id)));
    }

    @RequestMapping(value = "/jstudent", method = RequestMethod.POST)
    public ResponseEntity<Student> saveOrUpdateJStudent(@RequestBody Student student){
    	Student savedStudent = studentService.saveOrUpdate(student);
        return ResponseEntity.ok(savedStudent);
    }


    @RequestMapping("/jstudent/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
    	studentService.delete(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}

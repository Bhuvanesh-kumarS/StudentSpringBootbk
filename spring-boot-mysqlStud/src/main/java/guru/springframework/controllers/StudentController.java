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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

import javax.validation.Valid;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class StudentController {
    private StudentService studentService;

    private StudentToStudentForm studentToStudentForm;

    @Autowired
    public void setStudentToStudentForm(StudentToStudentForm studentToStudentForm) {
        this.studentToStudentForm = studentToStudentForm;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/student/list";
    }

    @RequestMapping({"/student/list", "/student"})
    public String listStudent(Model model){
        model.addAttribute("students", studentService.listAll());
        return "student/list";
    }

    @RequestMapping("/student/show/{id}")
    public String getStudent(@PathVariable String id, Model model){
        model.addAttribute("student", studentService.getById(Long.valueOf(id)));
        return "student/show";
    }

    @RequestMapping("student/edit/{id}")
    public String edit(@PathVariable String id, Model model){
    	Student student = studentService.getById(Long.valueOf(id));
    	StudentForm studentForm = studentToStudentForm.convert(student);

        model.addAttribute("studentForm", studentForm);
        return "student/studentform";
    }

    @RequestMapping("/student/new")
    public String newStudent(Model model){
        model.addAttribute("studentForm", new StudentForm());
        return "student/studentform";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String saveOrUpdateStudent(@Valid StudentForm studentForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "student/studentform";
        }

        Student savedStudent = studentService.saveOrUpdateStudentForm(studentForm);
             return "redirect:/student/show/" + savedStudent.getId();
    }
    @RequestMapping("/student/delete/{id}")
    public String delete(@PathVariable String id){
    	studentService.delete(Long.valueOf(id));
        return "redirect:/student/list";
        
    }
}


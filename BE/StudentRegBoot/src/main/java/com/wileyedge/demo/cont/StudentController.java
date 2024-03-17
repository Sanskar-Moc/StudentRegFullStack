package com.wileyedge.demo.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wileyedge.demo.model.Student;
import com.wileyedge.demo.service.IService;

@Controller
public class StudentController {
    @Autowired
    private IService studentService;

    @GetMapping("/studentForm")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
//        System.out.println("i ran dude seriously");
        return "studentForm"; // assuming studentForm.jsp is your form view
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "studentForm"; // return to form if validation fails
        }
        studentService.save(student);
        return "success"; // redirect to the list of students after successful submission
    }
}

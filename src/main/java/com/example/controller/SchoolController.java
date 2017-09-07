package com.example.controller;

import com.example.entity.Student;
import com.example.entity.Teacher;
import com.example.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping(value = "/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/add/{name}")
    public String addTeacherAndStudent(
            @PathVariable(value = "name") String teacherName, RedirectAttributes attributes) {
        Teacher teacher = new Teacher(teacherName);
        Student student = new Student("Mike", 19, new Date());

        schoolService.insertTeacherAndStudent(teacher, student);

        attributes.addAttribute("studentName", student.getName());

        return "redirect:/school/show?teacherName={name}";
    }

    @RequestMapping(value = "/show")
    public String show(@RequestParam String teacherName,
                       @RequestParam String studentName, Model model) {
        model.addAttribute("teacherName", teacherName);
        model.addAttribute("studentName", studentName);
        return "school";
    }
}

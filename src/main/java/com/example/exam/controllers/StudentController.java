package com.example.exam.controllers;

import com.example.exam.dto.StudentDto;
import com.example.exam.models.StudentEntity;
import com.example.exam.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap){
        modelMap.addAttribute("students",studentService.findAll());
        return "students/list";
    }

    @GetMapping("/add")
    private String add(ModelMap modelMap){
        StudentDto studentDto = new StudentDto();
        modelMap.addAttribute("studentDto",studentDto);
        return "students/addOrEdit";
    }

    @PostMapping("/addOrEdit")
    private String saveOrUpdate(ModelMap modelMap , @Valid StudentDto studentDto , BindingResult result){
        if (result.hasErrors()){
            modelMap.addAttribute("message","please input all required fields");
            modelMap.addAttribute("studentDto",studentDto);
            return "students/addOrEdit";

        }
        if (studentDto.getId() != null && studentDto.getId() > 0){
            modelMap.addAttribute("message","updated");
        }else {
            modelMap.addAttribute("message","inserted");
        }
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentDto.getName());
        studentEntity.setId(studentDto.getId());
        studentEntity.setCodeStudent(studentDto.getCodeStudent());
        studentEntity.setGender(studentDto.getGender());
        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setPhone(studentDto.getPhone());
        studentEntity.setBirthDay(studentDto.getBirthDay());
        studentEntity.setHomeTown(studentDto.getHomeTown());

        studentService.save(studentEntity);
        modelMap.addAttribute("studentDto",studentDto);
        return "students/addOrEdit";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id , ModelMap modelMap) {

        Optional<StudentEntity> optionalStudent =  studentService.findById(id);
        StudentDto studentDto = new StudentDto();
        studentDto.setName(optionalStudent.get().getName());
        studentDto.setId(optionalStudent.get().getId());
        studentDto.setCodeStudent(optionalStudent.get().getCodeStudent());
        studentDto.setGender(optionalStudent.get().getGender());
        studentDto.setEmail(optionalStudent.get().getEmail());
        studentDto.setPhone(optionalStudent.get().getPhone());
        studentDto.setBirthDay(optionalStudent.get().getBirthDay());
        studentDto.setHomeTown(optionalStudent.get().getHomeTown());


        if (optionalStudent.isPresent()){
            modelMap.addAttribute("studentDto",optionalStudent.get());
        }else {
            return list(modelMap);
        }
        System.out.println("edit");
        return "students/addOrEdit";

    }
    @ModelAttribute(name = "students")
    public List<StudentEntity> getListStudent(){
        return (List<StudentEntity>) studentService.findAll();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id , ModelMap modelMap) {
        studentService.deleteById(id);
        return list(modelMap);
    }

}

package org.example.student.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.student.Mapper.StudentMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.student.pojo.Student;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*","null"})
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    private Gson gson=new Gson();
    @GetMapping("/get")
    public String getStudents(){
        List<Student> students = studentMapper.selectList(null);
        return gson.toJson(students);
    }

    @PostMapping("/add")
    public void addStudents(@RequestBody Student student){
        studentMapper.insert(student);
    }

    @PostMapping("/delete")
    public void delStudents(@RequestBody Student student)
    {
        studentMapper.deleteById(student);
    }

    @PostMapping("/update")
    public void upStudents(@RequestBody Student student){
        studentMapper.updateById(student);
    }

    @PostMapping("/search")
    public String search(@RequestBody HashMap<String,String> data) {
        String name=data.get("name");
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.like("name",name);
        List<Student> students = studentMapper.selectList(studentQueryWrapper);
        return gson.toJson(students);
    }

}

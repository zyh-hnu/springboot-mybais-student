package org.example.student.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import org.example.student.Mapper.UserMapper;
import org.example.student.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*","null"})
public class UserController {
    @Autowired
    private UserMapper userMapper;
    private Gson gson=new Gson();

    @PostMapping("/login")
    public String loginStudent(@RequestBody User user){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.setEntity(user);
        User user_selected = userMapper.selectOne(userQueryWrapper);
        if(user_selected==null){
            return "0";
        }
        return "1";
    }

    @PostMapping("/register")
    public void register(@RequestBody User user){
        int insert = userMapper.insert(user);
    }
}

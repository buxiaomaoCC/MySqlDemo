package com.example.demoww.controller;

import com.example.demoww.dao.DateDao;
import com.example.demoww.dao.UserDao;
import com.example.demoww.entity.DateEntify;
import com.example.demoww.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 页面显示
 * http://localhost:8080/front/login
 */
@Controller
@RequestMapping("/front/*")
public class webController {

//    @RequestMapping("/index")
//    public String index() {
//
//        return "index";
//    }


    @Autowired
    private UserDao userDao;
    @Autowired
    private DateDao dateDao;
    //index页面
    @RequestMapping("/main")
    public String index() {
        return "main";
    }

//    //注册页面
//    @RequestMapping("/register")
//    public String register(){
//        return "register";
//    }

    //登录页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

//    //注册方法
//    @RequestMapping("/addregister")
//    public String register(HttpServletRequest request){
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String password2 = request.getParameter("password2");
//        if (password.equals(password2)){
//            //将数据存到数据库里面
//            UserEntity userEntity = new UserEntity();
//            userEntity.setUsername(username);
//            userEntity.setPassword(password);
//            userDao.save(userEntity);
//            return "login";
//        }else {
//            return "register";
//        }
//    }

    //登录方法
    @RequestMapping("/addlogin")
    public String login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //查询数据库里有没有相应的用户
        UserEntity userEntity = userDao.findByUsernameAndPassword(username,password);
        String str = "";
        if (userEntity !=null){
            str = "main";
        }else {
            str = "login";
        }
        return str;
    }

    //得到返回的json数据
    @RequestMapping("/findAll")
    public @ResponseBody List<DateEntify> getJson(){
        return dateDao.findAll();
    }
}

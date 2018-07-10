package com.example.demoww.controller;

import com.example.demoww.dao.UserDao;
import com.example.demoww.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    /**
     * 得到全部的数据库数据
     */
    @GetMapping(value="/girls")
    public List<UserEntity> getAllList(){
        return userDao.findAll();
    }
    /**
     * 查询一条数据
     */
    @RequestMapping(value = "/girl")
    public UserEntity girlFindOne(HttpServletRequest request){
        String username = request.getParameter("username");
        if(username==null){
            return null;
        }
        UserEntity userEntity=userDao.findByUsername(username);
        if(userEntity!=null){
            return userEntity;
        }else {
         return null;
        }
    }
    /**
     *更新一条数据
     */
    @RequestMapping(value = "/updategirl")
    public UserEntity update(HttpServletRequest request){
        long id= Long.parseLong(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //查询数据库里有没有相应的用户
        UserEntity userEntity=userDao.findById(id);
        if(userEntity!=null){
            userEntity.setUsername(username);
            userEntity.setPassword(password);
            return userDao.save(userEntity);
        }else {
            return null;
        }
    }
    //删除一条数据
    @RequestMapping(value = "/delete")
    public List<UserEntity>deleteOne(HttpServletRequest request){
        long id= Long.parseLong(request.getParameter("id"));
        UserEntity userEntity=userDao.findById(id);
        if(id!=0){
            userDao.deleteById(id);
            return userDao.findAll();
        }else {
            return userDao.findAll();
        }
    }
}

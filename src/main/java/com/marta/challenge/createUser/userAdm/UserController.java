package com.marta.challenge.createUser.userAdm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserDAO userDAO;

    List<User> users = new ArrayList<User>();



    @ModelAttribute("users")
    public List<User> getUsers() {
        return this.userDAO.findAll();
    }
    @ModelAttribute("enum_state")
    public State[] getEnumState(){
        return State.values();
    }



    @GetMapping("/createUser")
    public String showUser(User user){

        return "user";
    }


    @GetMapping("/listUser")
    public String listUser(){
        return "listUser";
    }



    @PostMapping("/saveUser")
    public String saveUser(User user){



        this.userDAO.save(user);
        return "redirect:/listUser";
    }




    @GetMapping("/alterUser")
    public String updateUser(Integer id, Model model){

        User user = this.userDAO.getOne(id);
        model.addAttribute("user", user);
        return "user";

    }

    @GetMapping("/deleteUser")
    public String DeleteUser(Integer id){
        this.userDAO.deleteById(id);
        return "redirect:/listUser";
    }





}
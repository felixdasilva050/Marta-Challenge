package com.marta.challenge.createUser.accessController;

import com.marta.challenge.createUser.userAdm.User;
import com.marta.challenge.createUser.userAdm.UserDAO;
import com.marta.challenge.createUser.userAdm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AccessController {

    @Autowired
    private UserDAO userDAO;





    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/adm/home")
    public String showUser(){
        return "home";
    }







/*----------[validate]----------------*/
    @PostMapping("/login")
    public String login(String login, String password, HttpSession session,
                        RedirectAttributes redirectAttributes){
        User userOn = this.userDAO.findByLoginAndPassword(login,password);
        if(userOn == null){
            redirectAttributes.addFlashAttribute("message", "Login/senha inválidos");
            return "redirect:/";
        }else {
            session.setAttribute("userOn", userOn);
            return "redirect:/adm/home";
        }
    }

    @GetMapping("/logOut")
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "access_denied";
    }


}

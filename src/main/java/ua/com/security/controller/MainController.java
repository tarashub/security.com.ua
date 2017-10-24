package ua.com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.security.entity.User;
import ua.com.security.services.UserServise;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    private UserServise userServise;


    @GetMapping({"/", "/home"})
    public String index(ModelMap model) {
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model,Principal principal) {
        model.addAttribute("user", principal);
        return "admin";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }



    @PostMapping("/save")
        public String save (@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("email") String email
                            ) {
        userServise.save(new User(username,password,email));

            return "index";
        }
}

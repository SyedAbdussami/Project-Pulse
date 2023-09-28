package com.example.pma.controllers;

import com.example.pma.dao.UserRepository;
import com.example.pma.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepo;

    @GetMapping("/register")
    public String register(Model model){
        UserAccount userAccount=new UserAccount();
        model.addAttribute("userAccount",userAccount);
        return "security/register";
    }
    @PostMapping("/register/save")
    public String saveUser(UserAccount user,Model model){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "redirect:/";
    }
}

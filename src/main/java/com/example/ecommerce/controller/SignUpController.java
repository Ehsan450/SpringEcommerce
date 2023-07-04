package com.example.ecommerce.controller;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.SignupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/sign-up")
public class SignUpController {
    private final SignupService signupService;

    @Autowired
    public SignUpController(SignupService signupService) {
        this.signupService = signupService;
    }
    @GetMapping
    public ModelAndView signup(){
        return new ModelAndView("utils/sign-up");
    }
    @PostMapping("/")
    public ModelAndView doSignup(@Valid @ModelAttribute User user){
        this.signupService.signup(user);
        return new ModelAndView(new RedirectView("/login"));
    }


}

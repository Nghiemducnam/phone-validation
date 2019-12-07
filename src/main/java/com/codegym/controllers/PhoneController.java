package com.codegym.controllers;

import com.codegym.models.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/")
    public ModelAndView validateForm(){
        ModelAndView modelAndView = new ModelAndView("validation");
        modelAndView.addObject("validate", new PhoneNumber());
        return modelAndView;
    }

    @PostMapping("/validation")
    public ModelAndView doValidate(@Valid @ModelAttribute ("validate")PhoneNumber phoneNumber, BindingResult bindingResult){
    new PhoneNumber().validate(phoneNumber, bindingResult);
    if(bindingResult.hasFieldErrors()){
        ModelAndView modelAndView = new ModelAndView("validation");
        return modelAndView;
    }else {
        ModelAndView modelAndView = new ModelAndView("result");
        return modelAndView;
    }
    }
}
package com.sena.springweb.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping(path = {"/","","/index"})
    
    public ModelAndView index(ModelAndView mv){
        mv.addObject("msn", "Este mensaje viene del controlador");
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/home")
    public String home(){
        return "forward:/cliente";
    }
}
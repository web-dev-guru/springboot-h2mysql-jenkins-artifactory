package com.aws.devops.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/", "index","caonima"})
    public String getIndex(Model model){
        model.addAttribute("testname", "abcs");
        return "index";
    }

    @RequestMapping({"/home"})
    public String getHome(Model model){
        model.addAttribute("testname", "abcs");
        return "/page/home";
    }
}

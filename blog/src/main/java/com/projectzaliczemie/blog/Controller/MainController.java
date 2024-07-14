package com.projectzaliczemie.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Main Page");
        return "home";
    }

    @GetMapping("/booking")
    public String booking(Model model) {
        model.addAttribute("title", "Booking Page");
        return "Booking";
    }
}

package com.tts.ecommerceproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ControllerAdvice // This makes the `@ModelAttribute`s of this controller available to all
                  // controllers, for the navbar.
public class MainController {
    /*
    @Autowired
    ProductService productService;
    */

    @GetMapping("/")
    public String main() {
        return "main";
    }
}

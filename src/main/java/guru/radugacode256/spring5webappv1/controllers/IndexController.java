package guru.radugacode256.spring5webappv1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({" ", " /", "/index"})
    public String getIndexPage(){
        System.out.println("Inside My recipe project 444");

        return "index";
    }
}

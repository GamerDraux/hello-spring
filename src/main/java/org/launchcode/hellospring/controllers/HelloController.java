package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

//     Handles requests at /hello
    @GetMapping("hello")
    public String hello(Model model){
        String name = "Spring";
        String languageGreeting = "Hello, ";
        model.addAttribute("name", name);
        model.addAttribute("languageGreeting",
                languageGreeting);
        return "createMessage";
    }

    @GetMapping("goodbye")
    public String goodbye(Model model){
        String name = "Spring";
        String languageGreeting = "Goodbye, ";
        model.addAttribute("name", name);
        model.addAttribute("languageGreeting",
                languageGreeting);
        return "createMessage";
    }

    //handler that handles requests of form
    // /hello?name=launchcode
    @RequestMapping(method={RequestMethod.GET,
            RequestMethod.POST}, value="greeting")
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String languageGreeting = "Hello, ";
        model.addAttribute("name", name);
        model.addAttribute("languageGreeting", languageGreeting);
        return "createMessage";
    }

    //handler that handles requests in the form
    // /hello/name/launchcode
    @GetMapping("hello/{name}")
    public String helloWithPathParameter(@PathVariable String name, Model model){
        String languageGreeting = "Hello, ";
        model.addAttribute("name", name);
        model.addAttribute("languageGreeting",
                languageGreeting);
        return "createMessage";

    }

    @PostMapping("createMessage")
    public String createMessage(@RequestParam String name
            , String language, Model model){
        String languageGreeting;
        switch (language) {
            case "English" -> languageGreeting =
                    "Hello, ";
            case "Spanish" -> languageGreeting =
                    "Hola, ";
            case "German" -> languageGreeting = "Hallo, ";
            case "Russian" -> languageGreeting =
                    "Привет, ";
            case "Japanese" -> languageGreeting =
                    "こんにちは, ";
            default -> languageGreeting = "Don't know that" +
                    " language," +
                    " but " +
                    "Hello ";
        }
        model.addAttribute("languageGreeting",
                languageGreeting);
        model.addAttribute("name", name);
        return "createMessage";

    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
            List<String> names = new ArrayList<>();
            names.add("John");
            names.add("Java");
            names.add("Jacob");
            model.addAttribute("names", names);
        return "hello-list";
    }
}

package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
@ResponseBody
public class HelloController {

//     Handles requests at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handler that handles requests of form
    // /hello?name=launchcode
    @RequestMapping(method={RequestMethod.GET,
            RequestMethod.POST}, name="name")
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, "+name+"!";
    }

    //handler that handles requests in the form
    // /hello/launchcode
    @GetMapping("hello/name")
    public String helloWithPathParameter(@PathVariable String name){
        return "Hello, "+name+"!";

    }

    @PostMapping("createMessage")
    public String createMessage(@RequestParam String name
            , String language){
        String languageGreeting;
        switch (language) {
            case "English" -> languageGreeting =
                    "Hello, ";
            case "Spanish" -> languageGreeting =
                    "Hola, ";
            case "German" -> languageGreeting = "Hallo";
            case "Russian" -> languageGreeting =
                    "Привет, ";
            case "Japanese" -> languageGreeting =
                    "こんにちは";
            default -> languageGreeting = "Don't know that" +
                    " language," +
                    " but " +
                    "Hello ";
        }
        return "<html>" +
                "<body style='background-color:red'>" +
                "<p style='color:blue; text-align:center;" +
                " font-size:30;" +
                "'>"+languageGreeting+name+
                "!</p>"+
                "</body>" +
                "</html>";

    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='createMessage' " +
                "method='post'>" +
                "<input type='text' name='name'>"+
                "<select type='text' name='language'>" +
                "<option value='English'>English</option>"+
                "<option value='Spanish'>Spanish</option>"+
                "<option value='German'>German</option>"+
                "<option value='Russian'>Russian</option>"+
                "<option value='Japanese'>Japanese" +
                "</option>"+
                "</select>"+
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}

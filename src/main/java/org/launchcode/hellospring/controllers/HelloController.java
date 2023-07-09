package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
//@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // Handles request at path /hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }
//
//    // Handles request of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }
//
//    // Handles request of the form /hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }
//
//    // Display form, lives at /hello/form
//    @GetMapping("form")
//    public String helloForm() {
//        return "<html>" +
//                    "<body>" +
//                        "<form action='hello' method='post'>" + //submits a request to /hello
//                            "<input type='text' name='name'>" +
//                            "<input type='submit' value='Greet me!'>" +
//                        "</form>" +
//                    "</body>" +
//                "</html>";
//    }

    @GetMapping
    public String nameLanguageForm() {
        return "<html>" +
                    "<body>" +
                        "<form method='post' action='greeting'>" +
                            "<input type='text' name='name'>" +
                            "<select name='language'>" +
                                "<option value='english'>English</option>" +
                                "<option value='spanish'>Spanish</option>" +
                                "<option value='french'>French</option>" +
                                "<option value='italian'>Italian</option>" +
                                "<option value='german'>German</option>" +
                            "</select>" +
                            "<button type='submit'>Greet me!</button>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "greeting")
    public String greeting(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);
    }

    public static String createMessage(String name, String language) {
        String response;

        switch (language) {
            case "english":
                response = "Hello " + name + "!";
                break;
            case "spanish":
                response = "Hola " + name + "!";
                break;
            case "french":
                response = "Bonjour " + name + "!";
                break;
            case "italian":
                response = "Ciao " + name + "!";
                break;
            default:
                response = "Guten Tag " + name + "!";
        }

        return "<html>" +
                    "<body>" +
                        "<h1 style='color: purple'>" + response + "</h1>" +
                    "</body>" +
                "</html>";
    }
}

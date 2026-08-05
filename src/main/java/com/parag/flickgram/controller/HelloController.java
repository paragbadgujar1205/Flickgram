package com.parag.flickgram.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping()   // it basically used to consistant Url path
@RestController     //  it helps to return data it contains @Controller + @RequestBody
public class HelloController {
    @GetMapping("/")   //it map get method to class method
    public String hello() {
        return "Hello spring boot I am Parag Badgujar. Learning SpringBoot.";
    }

//    @GetMapping("/users/{id}")
//    public String getUser(@PathVariable int id) {  // @PathVariable is used to fetch value in Url path
//        return "user id:- " + id;
//    }
//
//    @GetMapping("/users")
//    public String getUserQuery(@RequestParam String name) {  // @PathVariable is used to fetch value in Url path
//        return "user name:- " + name;
//    }
}
//    @GetMapping("/users/")
//    public String getUserJson(@RequestBody User user){  // @PathVariable is used to fetch value in Url path
//        return "user data:- "+ user.getName();
//    }
//}

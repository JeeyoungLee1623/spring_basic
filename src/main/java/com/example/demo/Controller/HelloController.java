package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//나는 컨트롤러야.
@Controller
public class HelloController {
    /*@GetMapping("hello")
     public String hello(Model model){

        model.addAttribute("name","gunyong");

        return "hello";
    }*/

    @GetMapping("hello")
    public String hello(@RequestParam(value="name")String name, Model model){

        model.addAttribute("name",name);

        return "hello";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String hellostring(){

        return "hello-string";
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(value="name") String name){
        Hello hello = new Hello();
        String name1 = name;
        hello.setName(name1);
        return hello;
    }

    static class Hello{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name1){
            this.name = name1;
        }
    }
}

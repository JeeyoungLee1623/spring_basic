package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // http://localhost:8080/hello 로 요청시 hello 메서드에서 처리 
    // http 는 국제 통신 프로토콜 이다. 전세계 통용 https 는 (s-secure) 보안이 강화된 통신 프로토콜
    // port 란 한 IP 내에 여러 프로그램을 구분짓는 단위 (하나의 컴퓨터에서 중복 사용은 안됨) (집주소가 IP, 각 집의 방 문이 Port)
    // data 만을 return 할 때는 responseBody 를 사용한다.

    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    // jsp / thymeleaf 같은 템플릿 엔진을 사용하여 화면을 return 할 때에는 responsebody 를 사용하면 안된다.
    // responsebody 없고, string 으로 되어 있으면 thymeleaf 로 된다.
    // 그리고 Model 이라는 객체에 data 를 담아 return xxx 를 하여 xxx.html 파일로 테이터를 보낸다.

    @GetMapping("hello-thymeleaf")
    public String hello2(Model model){
        model.addAttribute("getdata", "hello2 world");
        return "hello";
    }


    





}

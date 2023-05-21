package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    // http://localhost:8080/hello 로 요청시 hello 메서드에서 처리 
    // http 는 국제 통신 프로토콜 이다. 전세계 통용 https 는 (s-secure) 보안이 강화된 통신 프로토콜
    // port 란 한 IP 내에 여러 프로그램을 구분짓는 단위 (하나의 컴퓨터에서 중복 사용은 안됨) (집주소가 IP, 각 집의 방 문이 Port)
    // data 만을 return 할 때는 responseBod
    // y 를 사용한다.

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
        return "hello-th";
    }



    // 데이터를 첨부 시키지 않고, 화면만을 랜더링(준다라는 의미) 할 수도 있다.
    @GetMapping("hello-html")
    public String helloHtml(){
        return "hello-get-req";
    }

    //get 요청에 param 에 id 값을 넣어서 data 를 요청
    @GetMapping("hello-param")
    @ResponseBody
    public String helloParam(@RequestParam(value="id")String id){
        return "ok";
    }

    @GetMapping("hello-post-form-req")
    public String helloGetFormReq(){
        return "hello-post-form-req";

    }
    // html 의 form 형식으로 post 요청
    // form 형식의 경우 parameter 로 데이터가 넘어오므로, RequestParam 으로 받아줘야 한다.
    @PostMapping("hello-post-form-req")
    @ResponseBody
    public String helloPostFormReq(@RequestParam(value = "name")String myname,
                                 @RequestParam(value = "email")String myemail,
                                 @RequestParam(value = "password")String mypassword){
        System.out.println("이름: " + myname);
        System.out.println("이메일: " + myemail);
        System.out.println("비밀번호: " + mypassword);
        return "OK";
    }
    // 간소화 방법
//    public String helloPostFormReq(Hello hello){
//        System.out.println("이름: " + hello.getName());
//        System.out.println("이메일: " + hello.getEmail());
//        System.out.println("비밀번호: " + hello.getPassword());
//        return "ok";
//    }



    // 테스트를 할 때에, localhost:8080/hello-parameter?test=hello
    @GetMapping("hello-parameter")
    @ResponseBody
    public String helloParameter(@RequestParam(value = "test")String mytest){
        System.out.println("클라이언트가 보내온 parameter는? " + mytest);
        return "ok";
    }


    // json 으로 post 요청을 하기 위한 화면 return
    @GetMapping("hello-get-json-req")
    public String helloGetJsonReq(){
        return "hello-post-json-req";
    }

    // json 으로 post 요청이 등러왔을때는 data 를 꺼내기 위해 RequestBody 사용
    @PostMapping("hello-json")
    @ResponseBody
    public String helloJson(@RequestBody Hello hello){
        System.out.println("이름: " + hello.getName());
        System.out.println("이메일: " + hello.getEmail());
        System.out.println("비밀번호: " + hello.getPassword());
        return "ok";
    }

    // ResponseBody 어노테이션이 붙어 있고, return 타입이 객체이면 Spring 이 json 형태로 변환해준다.
    @PostMapping("hello-json-response")
    @ResponseBody
    public GoodBye helloJsonResponse(@RequestBody Hello hello){
        System.out.println("이름: " + hello.getName());
        System.out.println("이메일: " + hello.getEmail());
        System.out.println("비밀번호: " + hello.getPassword());
        GoodBye goodBye1 = new GoodBye();
        goodBye1.setName(hello.getName());
        goodBye1.setEmail(hello.getEmail());
        goodBye1.setComments("Thank you");
        return goodBye1;
    }



    // 사용자가 서버로 데이터를 보내는 방식에는 총 3가지가 있다.
    // 1. ? 통해 parameter 값을 넣어 보내는 방식 : 대부분 get 요청시 사용
    // 2. form 태그 안에 data 를 넣어 보내는 방식 : post 요청시 사용
    // (보안이 강화되고, url 에 데이터가 찍히지 않는다.) 그런데, 내부적으로는 ?key1=value2&key2=value2 의 형식을 취한다.)
    // 3. json 데이터 형식으로 서버로 보내는 방식 : post 요청시 사용
    // jason 데이터란 {"key1":"value1", "key2":"value2"} 의 형식을 취하는 형태이다.
    // 현대적인 web 서비스에서 대부분의 데이터를 주고 받을 때 json 을 사용한다.
    // json 은 html 의 form 태그처럼 넣어서 보내는 방식이 아니다보니, ajax, react 이런 javascript 프레임워크를 사용하게 된다.












}

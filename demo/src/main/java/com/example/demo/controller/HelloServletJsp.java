package com.example.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//    controller 가 아닌 servlet 을 통해 jsp 화면을 랜더링
//    controller 에서 jsp 화면을 랜더링 하는 방법도 존재하나. 설정이 다소 복잡하여 pass
    @WebServlet(name = "helloServletJsp", urlPatterns = "/hello-servlet-jsp")
    public class HelloServletJsp extends HttpServlet {
        @Override
        protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("getdata", "test data");
//        아래와 같이 path 를 잡으면 webapp 밑에 아래 경로로 jsp 파일을 찾으러 간다.
            String path = "WEB-INF/views/hello-jsp.jsp";
            RequestDispatcher rd = req.getRequestDispatcher(path);
            rd.forward(req, resp);
        }
    }


package com.examination_system.controller;

import com.examination_system.model.entity.User;
import com.examination_system.service.UserService;
import com.examination_system.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program examination-system
 * @description: ${TODO}
 * @author: yao
 * @create: 2020/11/27 21:54
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String) req.getParameter("name");
        String password = (String) req.getParameter("password");
        User user = service.getLoginUser(name, password);
        if (user == null) {
            req.setAttribute("message", "用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

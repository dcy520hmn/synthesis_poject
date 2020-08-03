package com.dcy.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        System.out.println("init-params:"+this.getServletConfig().getInitParameter("test"));
        System.out.println("context-params:"+this.getServletContext().getInitParameter("url"));
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
    }

    @Override
    public void destroy() {
        System.out.println("进行销售");
    }
}

package controller;

import service.impl.RegisterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Stalary on 17/5/10.
 */
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//解决传入的值中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决输出的值中文乱码问题
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        RegisterServiceImpl re = new RegisterServiceImpl(account,password,name,phone);
        int tempReturn = re.judge();
        if(account.equals("")||account.equals(null)) {
            response.sendRedirect(request.getContextPath() + "/register_false_format.jsp");
        } else{
            if (tempReturn == 1) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/register_false.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

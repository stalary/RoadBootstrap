package controller;

import service.impl.LoginServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Stalary on 17/5/10.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String type = request.getParameter("radio");
        request.getSession().setAttribute("accountType", type);
        LoginServiceImpl login = new LoginServiceImpl(account,password,type);
        int tempReturn = login.judge();
        if(tempReturn == 1) {
            request.getSession().setAttribute("name", account);//把用户数据保存在session域对象中
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else if(tempReturn == 2) {
            UserServiceImpl roadUser = new UserServiceImpl("查询道路");
            List listRoad = roadUser.Judge();
            UserServiceImpl reserveUser = new UserServiceImpl("查询预约情况");
            List listReserve = reserveUser.Judge();
            request.getSession().setAttribute("listRoad",listRoad);
            request.getSession().setAttribute("listReserve",listReserve);
            response.sendRedirect(request.getContextPath() + "/manager.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/login_false.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

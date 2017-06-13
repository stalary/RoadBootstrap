package controller;

import service.impl.AdminServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Stalary on 17/5/17.
 */
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//解决传入的值中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决输出的值中文乱码问题
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        AdminServiceImpl admin = new AdminServiceImpl(id,type);
        int tempReturn = admin.judge();
        if(tempReturn == 1) {
            if (type.equals("管理预约")) {
                UserServiceImpl user = new UserServiceImpl("查询预约情况");
                List list = user.Judge();
                request.getSession().setAttribute("listReserve", list);
                response.sendRedirect(request.getContextPath() + "/managerReserve.jsp");
            } else {
                UserServiceImpl user = new UserServiceImpl("查询道路");
                List list = user.Judge();
                request.getSession().setAttribute("listRoad", list);
                response.sendRedirect(request.getContextPath() + "/managerRoad.jsp");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

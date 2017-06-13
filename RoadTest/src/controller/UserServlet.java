package controller;

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
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//解决传入的值中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决输出的值中文乱码问题
        String accountType = (String) request.getSession().getAttribute("accountType");
        String type = request.getParameter("button");
        UserServiceImpl user = new UserServiceImpl(type);
        if(accountType.equals("user")) {
            if (type.equals("预约")) {
                List list = user.Judge();
                request.getSession().setAttribute("list", list);
                response.sendRedirect(request.getContextPath() + "/reserve.jsp");
            } else if (type.equals("取消预约")) {
                List list = user.Judge();
                request.getSession().setAttribute("list", list);
                response.sendRedirect(request.getContextPath() + "/cancelReserve.jsp");
            } else if (type.equals("查询道路")) {
                List list = user.Judge();
                request.getSession().setAttribute("list", list);
                response.sendRedirect(request.getContextPath() + "/roadRecord.jsp");
            } else if (type.equals("查询预约情况")) {
                List list = user.Judge();
                request.getSession().setAttribute("list", list);
                response.sendRedirect(request.getContextPath() + "/reserveRecord.jsp");
            }
        } else {
            if(type.equals("管理预约")) {
                List list = user.Judge();
                request.getSession().setAttribute("list", list);
                response.sendRedirect(request.getContextPath() + "/managerReserve.jsp");
            } else if(type.equals("管理道路")) {
                List list = user.Judge();
                request.getSession().setAttribute("list", list);
                response.sendRedirect(request.getContextPath() + "/managerRoad.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

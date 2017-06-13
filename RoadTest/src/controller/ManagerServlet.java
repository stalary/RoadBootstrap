package controller;

import service.impl.ManagerServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Stalary on 17/5/15.
 */
public class ManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//解决传入的值中文乱码问题
        response.setContentType("text/html;charset=utf-8");//解决输出的值中文乱码问题
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String name = (String) request.getSession().getAttribute("name");
        ManagerServiceImpl manager = new ManagerServiceImpl(id,name,type);
        int tempReturn = manager.judge();
        if(tempReturn == 1) {
            UserServiceImpl user = new UserServiceImpl("查询道路");
            List list = user.Judge();
            request.getSession().setAttribute("list",list);
            response.sendRedirect(request.getContextPath() + "/roadRecord.jsp");
        }
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

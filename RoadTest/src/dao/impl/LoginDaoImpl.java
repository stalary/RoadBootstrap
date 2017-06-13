package dao.impl;
import dao.LoginDao;
import dbconnect.GetConnect;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
* @Author:Stalary
* @package:登录Dao
* @Description:dao.impl
* @Date: 17/5/18 下午12:48
* @Version:v1.0.0
*/
public class LoginDaoImpl implements LoginDao{
    private PreparedStatement pstmt = null;
    private Connection conn = null;
    private ResultSet rs = null;
    private String sql = null;
    private Statement stmt = null;
    private String queryPassword = null;
    User user = new User();
    List<String> list = new ArrayList<>();
    public LoginDaoImpl(){}

    public LoginDaoImpl(String account) {
        user.setAccount(account);
    }
    /**
    * @Description:查询用户密码
    * @Author:Stalary
    * @Date 17/5/18 下午12:45
    * @Params:
    * @Return:String
    */
    @Override
    public String queryUser() {
        try {
            conn = GetConnect.connect();
            sql = "select password from users where account = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getAccount());
            rs = pstmt.executeQuery();
            rs.next();
            queryPassword = rs.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            GetConnect.close();
        }
        return queryPassword;
    }
    /**
    * @Description:查询管理员
    * @Author:Stalary
    * @Date 17/5/18 下午12:49
    * @Params:
    * @Return:Sting
    */
    @Override
    public String queryManager() {
        try {
            conn = GetConnect.connect();
            sql = "select password from manager where account = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getAccount());
            rs = pstmt.executeQuery();
            rs.next();
            queryPassword = rs.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            GetConnect.close();
        }
        return queryPassword;
    }
    /**
    * @Description:是否存在该用户
    * @Author:Stalary
    * @Date 17/5/18 下午12:50
    * @Params:
    * @Return:List
    */
    @Override
    public List existUser() {
        RegisterDaoImpl re = new RegisterDaoImpl();
        return re.queryUser();
    }
    /**
    * @Description:是否存在该管理员
    * @Author:Stalary
    * @Date 17/5/18 下午12:50
    * @Params:
    * @Return:List
    */
    @Override
    public List existManager() {
        try {
            conn = GetConnect.connect();
            stmt = conn.createStatement();
            sql = "select account from manager";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                list.add(rs.getString("account"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            GetConnect.close();
        }
        return list;
    }
}

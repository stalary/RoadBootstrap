package dao.impl;

import dao.RegisterDao;
import dbconnect.GetConnect;
import entity.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
* @Author:Stalary
* @package:dao.impl
* @Description:注册Dao
* @Date: 17/5/18 下午12:49
* @Version:v1.0.0
*/
public class RegisterDaoImpl implements RegisterDao{
    private PreparedStatement pstmt = null;
    private Connection conn = null;
    private ResultSet rs = null;
    private String sql = null;
    private Statement stmt = null;
    private String queryPassword = null;
    User user = new User();
    List<String> list = new ArrayList<>();
    public RegisterDaoImpl() {}

    public RegisterDaoImpl(String account,String password,String name,String phone) {
        user.setAccount(account);
        user.setPassword(password);
        user.setName(name);
        user.setPhone(phone);
    }
    /**
    * @Description:增加用户
    * @Author:Stalary
    * @Date 17/5/18 下午12:52
    * @Params:
    * @Return:int
    */
    @Override
    public int insertUser() {
        try {
            conn = GetConnect.connect();
            sql = "insert into users (account,password,name,phone) values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getAccount());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getName());
            pstmt.setString(4,user.getPhone());
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            GetConnect.close();
        }
        return -1;
    }
    /**
    * @Description:查询用户
    * @Author:Stalary
    * @Date 17/5/18 下午12:52
    * @Params:
    * @Return:List
    */
    @Override
    public List queryUser() {
        try {
            conn = GetConnect.connect();
            stmt = conn.createStatement();
            sql = "select account from users";
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

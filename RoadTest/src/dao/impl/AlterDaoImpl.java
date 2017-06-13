package dao.impl;

import dao.AlterDao;
import dbconnect.GetConnect;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
* @Author:Stalary
* @package:dao.impl
* @Description:修改Dao
* @Date: 17/5/18 下午12:46
* @Version:v1.0.0
*/
public class AlterDaoImpl implements AlterDao{
    private PreparedStatement pstmt = null;
    private Connection conn = null;
    private ResultSet rs = null;
    private String sql = null;
    private Statement stmt = null;
    private String queryPassword = null;
    User user = new User();
    List<String> list = new ArrayList<>();
    public AlterDaoImpl() {}

    public AlterDaoImpl(String account,String password,String name,String phone) {
        user.setAccount(account);
        user.setPassword(password);
        user.setName(name);
        user.setPhone(phone);
    }
    /**
    * @Description:修改用户信息
    * @Author:Stalary
    * @Date 17/5/18 下午12:45
    * @Params:
    * @Return:int
    */
    @Override
    public int alterUser() {
        try {
            conn = GetConnect.connect();
            sql = "update users set password=? where account=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getPassword());
            pstmt.setString(2,user.getAccount());
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
    * @Description:查询用户信息
    * @Author:Stalary
    * @Date 17/5/18 下午12:45
    * @Params:
    * @Return:List
    */
    public List queryUser() {
        RegisterDaoImpl register = new RegisterDaoImpl();
        list = register.queryUser();
        return list;
    }
}

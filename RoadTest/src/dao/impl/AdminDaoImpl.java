package dao.impl;

import dao.AdminDao;
import dbconnect.GetConnect;
import entity.Reserve;
import entity.Road;

import java.sql.*;

/**
* @Author:Stalary
* @package:dao.impl
* @Description:管理员处理Dao
* @Date: 17/5/18 下午12:47
* @Version:v1.0.0
*/
public class AdminDaoImpl implements AdminDao{
    private PreparedStatement pstmt = null;
    private Connection conn = null;
    private ResultSet rs = null;
    private String sql = null;
    private Statement stmt = null;
    private String queryPassword = null;
    Road road = new Road();
    Reserve reserve = new Reserve();

    public AdminDaoImpl(){}

    public AdminDaoImpl(String id){
        road.setId(id);
        reserve.setId(id);
    }
/**
* @Description:删除预约记录
* @Author:Stalary
* @Date 17/5/18 下午12:43
* @Params:
* @Return:int
*/
    @Override
    public int deleteReserve() {
        try {
            conn = GetConnect.connect();
            sql = "delete from reserve where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,reserve.getId());
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
    * @Description:删除道路信息
    * @Author:Stalary
    * @Date 17/5/18 下午12:44
    * @Params:
    * @Return:int
     *@Impor:删除时要注意主外键的关联
    */
    @Override
    public int deleteRoad() {
        try {
            conn = GetConnect.connect();
            sql = "delete from road where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,road.getId());
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            GetConnect.close();
        }
        return -1;
    }
}

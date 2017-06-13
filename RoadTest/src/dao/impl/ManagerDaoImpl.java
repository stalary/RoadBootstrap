package dao.impl;

import dao.ManagerDao;
import dbconnect.GetConnect;
import entity.Reserve;
import entity.Road;

import java.sql.*;

/**
* @Author:Stalary
* @package:dao.impl
* @Description:管理Dao
* @Date: 17/5/18 下午12:48
* @Version:v1.0.0
*/
public class ManagerDaoImpl implements ManagerDao{
    private PreparedStatement pstmt = null;
    private Connection conn = null;
    private ResultSet rs = null;
    private String sql = null;
    private Statement stmt = null;
    private String queryPassword = null;
    Road road = new Road();
    Reserve reserve = new Reserve();

    public ManagerDaoImpl(){}

    public ManagerDaoImpl(String id, String name){
        road.setId(id);
        reserve.setId(id);
        reserve.setName(name);
    }

    /**
    * @Description:预约
    * @Author:Stalary
    * @Date 17/5/18 下午12:51
    * @Params:
    * @Return:int
    */
    @Override
    public int reserveRoad() {
        try {
            conn = GetConnect.connect();
            sql = "update road set state='已预约' where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, road.getId());
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
    * @Description:取消预约
    * @Author:Stalary
    * @Date 17/5/18 下午12:51
    * @Params:
    * @Return:int
    */
    @Override
    public int cancelReserveRoad() {
        try {
            conn = GetConnect.connect();
            sql = "update road set state='未预约' where id=?";
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
    /**
    * @Description:增加预约记录
    * @Author:Stalary
    * @Date 17/5/18 下午12:51
    * @Params:
    * @Return:int
    */
    @Override
    public int insertReserve() {
        try {
            conn = GetConnect.connect();
            sql = "insert into reserve (name,id) values(?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,reserve.getName());
            pstmt.setString(2,reserve.getId());
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
    * @Description:删除预约记录
    * @Author:Stalary
    * @Date 17/5/18 下午12:52
    * @Params:
    * @Return:int
    */
    @Override
    public int cancelInsertReserve() {
        try {
            conn = GetConnect.connect();
            sql = "delete from reserve where name=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,reserve.getName());
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

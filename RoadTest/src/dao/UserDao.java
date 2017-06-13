package dao;

import java.util.List;

/**
 * Created by Stalary on 17/5/12.
 */
public interface UserDao {
    List reserve();//预约
    List cancelReserve();//取消预约
    List queryRoad();//查询道路表
    List queryReserve();//查询预约表
}

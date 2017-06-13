package dao;

/**
 * Created by Stalary on 17/5/15.
 */
public interface ManagerDao {
    int reserveRoad();//预约道路
    int cancelReserveRoad();//取消预约道路
    int insertReserve();//增加预约
    int cancelInsertReserve();//删除预约
}

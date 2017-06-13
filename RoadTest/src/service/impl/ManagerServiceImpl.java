package service.impl;

import dao.impl.ManagerDaoImpl;
import service.ManagerService;

/**
* @Author:Stalary
* @package:service.impl
* @Description:管理逻辑层
* @Date: 17/5/18 下午12:58
* @Version:v1.0.0
*/
public class ManagerServiceImpl implements ManagerService{
    private String id;
    private String name;
    private String type;
    public ManagerServiceImpl(){}

    public ManagerServiceImpl(String id, String name, String type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    /**
    * @Description:逻辑判断
    * @Author:Stalary
    * @Date 17/5/18 下午12:59
    * @Params:
    * @Return:int
    */
    @Override
    public int judge() {
        ManagerDaoImpl manager = new ManagerDaoImpl(this.id,this.name);
        if(type.equals("预约")) {
            int temp = manager.reserveRoad();
            if (temp == 1) {
                int temp1 = manager.insertReserve();
                if (temp1 == 1) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return -1;
        } else if(type.equals("取消预约")){
            int temp = manager.cancelReserveRoad();
            if (temp == 1) {
                int temp1 = manager.cancelInsertReserve();
                if (temp1 == 1) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return -1;
        }
        return 0;
    }
}

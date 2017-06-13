package service.impl;

import dao.impl.AdminDaoImpl;
import service.AdminService;

/**
* @Author:Stalary
* @package:service.impl
* @Description:用户逻辑层
* @Date: 17/5/18 下午12:57
* @Version:v1.0.0
*/
public class AdminServiceImpl  implements AdminService{
    private String id;
    private String type;

    public AdminServiceImpl(){}

    public AdminServiceImpl(String id, String type){
        this.id = id;
        this.type = type;
    }
    /**
    * @Description:逻辑判断
    * @Author:Stalary
    * @Date 17/5/18 下午12:57
    * @Params:
    * @Return:int
    */
    @Override
    public int judge() {
        AdminDaoImpl admin = new AdminDaoImpl(this.id);
        if(this.type.equals("管理预约")) {
            int temp = admin.deleteReserve();
            if(temp == 1) {
                return 1;
            } else {
                return -1;
            }
        } else {
            int temp = admin.deleteRoad();
            if(temp == 1) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}

package service.impl;

import dao.impl.UserDaoImpl;
import service.UserService;

import java.util.ArrayList;
import java.util.List;


/**
* @Author:Stalary
* @package:service.impl
* @Description:
* @Date: 17/5/18 下午12:59
* @Version:v1.0.0
*/
public class UserServiceImpl implements UserService{
    private String type;

    public UserServiceImpl() {}

    public UserServiceImpl(String type) {
        this.type = type;
    }
    /**
    * @Description:逻辑判断
    * @Author:Stalary
    * @Date 17/5/18 下午12:59
    * @Params:
    * @Return:List
    */
    @Override
    public List Judge() {
        UserDaoImpl user = new UserDaoImpl();
        List list = new ArrayList();
        if(this.type.equals("预约")) {
            list = user.reserve();
            return list;
        } else if(this.type.equals("取消预约")) {
            list = user.cancelReserve();
            return list;
        } else if(this.type.equals("查询预约情况")) {
            list = user.queryReserve();
            return list;
        } else if(this.type.equals("查询道路")) {
            list = user.queryRoad();
            return list;
        }
        return list;
    }
}

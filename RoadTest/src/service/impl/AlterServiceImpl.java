package service.impl;

import dao.impl.AlterDaoImpl;
import service.AlterService;

import java.util.List;

/**
* @Author:Stalary
* @package:service.impl
* @Description:修改逻辑层
* @Date: 17/5/18 下午12:57
* @Version:v1.0.0
*/
public class AlterServiceImpl implements AlterService{
    private String account;
    private String password;
    private String name;
    private String phone;

    public AlterServiceImpl() {}

    public AlterServiceImpl(String account,String password,String name,String phone) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }
    /**
    * @Description:逻辑判断
    * @Author:Stalary
    * @Date 17/5/18 下午12:58
    * @Params:
    * @Return:int
    */
    public int judge() {
        AlterDaoImpl alter = new AlterDaoImpl(this.account, this.password, this.name, this.phone);
        List list = alter.queryUser();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(this.account)) {
                count++;
            }
        }
        if(count == 0) {
            return -1;
        }
        int temp = alter.alterUser();
        if (temp == 1) {
            return 1;
        }
        return -1;
    }
}

package service.impl;

import dao.impl.RegisterDaoImpl;
import service.RegisterService;

import java.util.List;

/**
* @Author:Stalary
* @package:service.impl
* @Description:注册逻辑层
* @Date: 17/5/18 下午12:59
* @Version:v1.0.0
*/
public class RegisterServiceImpl implements RegisterService {
    private String account;
    private String password;
    private String name;
    private String phone;

    public RegisterServiceImpl() {}

    public RegisterServiceImpl(String account,String password,String name,String phone) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.phone = phone;
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
        RegisterDaoImpl re = new RegisterDaoImpl(this.account, this.password, this.name, this.phone);
        List list = re.queryUser();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(this.account)) {
                return -1;
            }
        }
        int temp = re.insertUser();
        if (temp == 1) {
            return 1;
        }
        return -1;
    }
}

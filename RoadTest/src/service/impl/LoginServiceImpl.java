package service.impl;

import dao.impl.LoginDaoImpl;
import service.LoginService;

import java.util.List;

/**
* @Author:Stalary
* @package:service.impl
* @Description:登录逻辑层
* @Date: 17/5/18 下午12:58
* @Version:v1.0.0
*/
public class LoginServiceImpl implements LoginService{
    private String account;
    private String password;
    private String type;

    public LoginServiceImpl() {}

    public LoginServiceImpl(String account, String password, String type) {
        this.account = account;
        this.password = password;
        this.type = type;
    }
    /**
    * @Description:逻辑判断
    * @Author:Stalary
    * @Date 17/5/18 下午12:58
    * @Params:
    * @Return:int
    */
    @Override
    public int judge() {
        LoginDaoImpl login = new LoginDaoImpl(this.account);
        if(this.type.equals("user")) {
            List list = login.existUser();
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(this.account)) {
                    count++;
                }
            }
            if(count == 0) {
                return -1;
            }
            String tempPassword = login.queryUser();
            if(tempPassword.equals(this.password)) {
                return 1;
            } else {
                return -1;
            }
        } else if(this.type.equals("admin")){
            List list = login.existManager();
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(this.account)) {
                    count++;
                }
            }
            if(count == 0) {
                return -1;
            }
            String tempPassword = login.queryManager();
            if(tempPassword.equals(this.password)) {
                return 2;
            } else {
                return -1;
            }
        }
        return 0;
    }

}

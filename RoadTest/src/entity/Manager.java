package entity;

/**
* @Author:Stalary
* @package:entity
* @Description:guanli实体
* @Date: 17/5/18 下午12:54
* @Version:v1.0.0
*/
public class Manager {
    private String account;
    private String password;
    private String name;

    public Manager() {}

    public Manager(String account, String password, String name) {
        this.account = account;
        this.password = password;
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

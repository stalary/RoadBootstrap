package entity;

/**
* @Author:Stalary
* @package:entity
* @Description:用户实体
* @Date: 17/5/18 下午12:54
* @Version:v1.0.0
*/
public class User {
    private String account;
    private String password;
    private String name;
    private String phone;

    public User() {
    }

    public User(String account, String password, String name, String phone) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
package dao;

import java.util.List;

/**
 * Created by Stalary on 17/5/12.
 */
public interface LoginDao {
    List existUser();//查询是否存在该用户名
    List existManager();//查询是否存在该管理员
    String queryUser();//查询用户表
    String queryManager();//查询管理员表
}

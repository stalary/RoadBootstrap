package dao;
import java.util.List;
/**
 * Created by Stalary on 17/5/12.
 */
public interface RegisterDao {
    int insertUser();//插入新用户
    List queryUser();//查询用户
}

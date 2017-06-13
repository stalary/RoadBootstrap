package entity;

/**
* @Author:Stalary
* @package:entity
* @Description:预约实体
* @Date: 17/5/18 下午12:54
* @Version:v1.0.0
*/
public class Road {
    private String id;
    private String state;

    public Road() {}

    public Road(String id, String state) {
        this.id = id;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

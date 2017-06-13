package entity;

/**
* @Author:Stalary
* @package:entity
* @Description:预约实体
* @Date: 17/5/18 下午12:54
* @Version:v1.0.0
*/
public class Reserve {
    private String id;
    private String name;

    public Reserve() {}

    public Reserve(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

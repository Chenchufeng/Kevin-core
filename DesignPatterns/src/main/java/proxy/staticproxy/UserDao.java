package proxy.staticproxy;

/**
 * @Author: Kevin
 * @Date: 2021/8/17 20:32
 * @Description:
 */
/**
 * 接口实现
 * 目标对象
 */
public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
package proxy.staticproxy;

/**
 * @Author: Kevin
 * @Date: 2021/8/17 20:36
 * @Description: 代理对象,静态代理
 */
public class UserDaoProxy implements IUserDao{
    private IUserDao userDao;

    public UserDaoProxy(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("开始事务...");
        userDao.save();  //执行目标对象的方法
        System.out.println("提交事务...");
    }
}
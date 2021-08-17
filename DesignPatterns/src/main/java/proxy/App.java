package proxy;

import proxy.dynamicproxy.ProxyFactory;
import proxy.staticproxy.IUserDao;
import proxy.staticproxy.UserDao;
import proxy.staticproxy.UserDaoProxy;

/**
 * @Author: Kevin
 * @Date: 2021/8/17 20:40
 * @Description:
 * 静态代理总结:
 * 1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 2.缺点:
 *
 * 因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 * 如何解决静态代理中的缺点呢?答案是可以使用动态代理方式
 */
public class App {
    public static void main(String[] args) {
        //目标对象
        IUserDao target=new UserDao();
        System.out.println(target.getClass());
        //代理对象,把目标对象传给代理对象,建立代理关系
//        IUserDao userDao=new UserDaoProxy(target);
//        userDao.save();  //执行的是代理的方法
        ProxyFactory proxyFactory = new ProxyFactory(target);
        IUserDao dynamicProxy = (IUserDao) proxyFactory.dynamicProxy();
        System.out.println(dynamicProxy.getClass());
        dynamicProxy.save();
    }
}
package proxy.dynamicproxy;

/**
 * @Author: Kevin
 * @Date: 2021/8/17 20:46
 * @Description:
 * /**
 *  * 创建动态代理对象
 *  * 动态代理不需要实现接口,但是需要指定接口类型
 *  */

import proxy.staticproxy.IUserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    //维护一个目标对象
     private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象生成代理对象
    public Object dynamicProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            //proxy一般是指代理类，method是被代理的方法，args为该方法的参数数组
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始事务2");
                //执行目标对象方法
                Object object = method.invoke(target, args);
                System.out.println("提交事务2");
                return object;
            }
        });
    }
}
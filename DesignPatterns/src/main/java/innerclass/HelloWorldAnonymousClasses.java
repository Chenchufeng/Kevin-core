package innerclass;


/**
 * @Author: Kevin
 * @Date: 2021/8/25 23:13
 * @Description:
 */
public class HelloWorldAnonymousClasses {
    /**
     * 包含两个方法的HelloWorld接口
     */
    interface HelloWorld {
        public void greet();

        public void greetSomeone(String someone);
    }

    public void sayHello() {
        // 1、局部类EnglishGreeting实现了HelloWorld接口
        class EnglishGreeting implements HelloWorld {
            String name = "word";

            @Override
            public void greet() {
                greetSomeone("word");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        EnglishGreeting englishGreeting = new EnglishGreeting();

        // 2、匿名类实现HelloWorld接口
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";

            public void greet() {
                greetSomeone("tout le monde");
            }

            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        // 3、匿名类实现HelloWorld接口
        /**
         * 匿名类是一个表达式，匿名类的语法就类似于调用一个类的构建函数（new  HelloWorld()），除些之外，还包含了一个代码块，在代码块中完成类的定义
         */
        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };

        englishGreeting.greet();
        frenchGreeting.greetSomeone("Kevin");
        spanishGreeting.greet();
    }


    public static void main(String[] args) {
        HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }

}
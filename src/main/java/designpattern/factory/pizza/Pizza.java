package designpattern.factory.pizza;

/**
 * @Author: chufeng Chen
 * @Description: 将Pizza类做成抽象
 * @Date:Create：in 2021/3/20 12:08
 */
public abstract class Pizza {

    protected String name;

    //准备原材料
    public abstract void prepare();

    public void bake(){
        System.out.println(name+"baking");
    }
    public void cut(){
        System.out.println(name+"cutting");
    }
    public void box(){
        System.out.println(name+"boxing");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

public class CPU {
    public static void main(String[] args) {
        // 获取cpu的核数
        // CPU 密集型，IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
        // 如果电脑是8核，则结果输出8
    }
}

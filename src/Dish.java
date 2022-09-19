import java.util.concurrent.TimeUnit;

public class Dish {
    private String name;
    private Integer productionTime;

    public Dish(String name, Integer productionTime) {
        this.name=name;
        this.productionTime=productionTime;
    }

    void make() {
        SmallTool.sleepMillis(TimeUnit.SECONDS.toMillis(this.productionTime));
        SmallTool.printTimeAndThread(this.name + "制作完毕，来吃饭吧");
    }

    public void makeUseCPU() {
        SmallTool.printTimeAndThread("制作完毕，来吃饭吧" + compute());
    }

    //模拟耗时1s的操作
    private static long compute() {
        long startTime=System.currentTimeMillis();
        long result=0;
        for(int i=0;i<Integer.MAX_VALUE/6;i++) {
            result+=i*i*2%3;
        }
        return System.currentTimeMillis()-startTime;
    }

    public static void main(String[] args) {
        System.out.println(compute());
    }
}

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点餐");

        CompletableFuture<String> cf1=CompletableFuture.supplyAsync(()->{
           SmallTool.printTimeAndThread("做番茄炒鸡蛋");
           SmallTool.sleepMillis(200);
           SmallTool.printTimeAndThread("盛饭");
           SmallTool.sleepMillis(100);
           return "厨师做好了";
        });

        SmallTool.printTimeAndThread("小白打游戏");
        SmallTool.printTimeAndThread(String.format("%s,小白吃饭",cf1.join()));

    }
}

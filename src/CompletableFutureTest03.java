import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest03 {
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点餐");

        CompletableFuture<String> cf1=CompletableFuture.supplyAsync(()->{
           SmallTool.printTimeAndThread("做番茄炒鸡蛋");
           SmallTool.sleepMillis(200);
           return "番茄炒鸡蛋";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            SmallTool.printTimeAndThread("服务员蒸饭");
            SmallTool.sleepMillis(300);
            return "米饭";
        }),(dish, rice) -> {
            SmallTool.printTimeAndThread("服务员打饭");
            SmallTool.sleepMillis(100);
            return String.format("%s + %s 好了",dish,rice);
        });

        SmallTool.printTimeAndThread("小白打游戏");
        SmallTool.printTimeAndThread(String.format("%s,小白吃饭",cf1.join()));

    }
}

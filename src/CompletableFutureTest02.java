import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest02 {
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点餐");

        CompletableFuture<String> cf1=CompletableFuture.supplyAsync(()->{
           SmallTool.printTimeAndThread("做番茄炒鸡蛋");
           SmallTool.sleepMillis(200);
           return "番茄炒鸡蛋";
        }).thenCompose(dish->CompletableFuture.supplyAsync(()->{
            SmallTool.printTimeAndThread("服务员盛饭");
            SmallTool.sleepMillis(100);
            return dish+" + 米饭";
        }));

        SmallTool.printTimeAndThread("小白打游戏");
        SmallTool.printTimeAndThread(String.format("%s,小白吃饭",cf1.join()));

    }
}

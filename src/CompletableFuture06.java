import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CompletableFuture06 {
    public static void main(String[] args) {
        //System.setProperty("java.util,concurrent.ForkJoinPool.common.parallelism","10");
        //jvm可用的核心数
        System.out.println(Runtime.getRuntime().availableProcessors());
        //查看当前线程数
        System.out.println(ForkJoinPool.commonPool().getPoolSize());
        //查看最大线程数
        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        ExecutorService threadPool = Executors.newCachedThreadPool();

        SmallTool.printTimeAndThread("小白和朋友进餐厅点菜");
        long startTime=System.currentTimeMillis();


        //使用Stream API
        CompletableFuture[] dishes= IntStream.rangeClosed(1,5)
                .mapToObj(i->new Dish("菜" + i,1))
                .map(dish -> CompletableFuture.runAsync(dish::makeUseCPU, threadPool))
                .toArray(size->new CompletableFuture[size]);

        //等待所有任务执行完毕
        CompletableFuture.allOf(dishes).join();

        SmallTool.printTimeAndThread("菜都做好了，上桌" + (System.currentTimeMillis() - startTime));
        threadPool.shutdown();
    }
}

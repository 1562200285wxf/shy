import java.util.concurrent.CompletableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletableFuture07 {
    public static void main(String[] args) {
        //自测线程复用的情况
        ThreadPoolExecutor executor=new ThreadPoolExecutor(0,Integer.MAX_VALUE,
                0, TimeUnit.MILLISECONDS, new SynchronousQueue<>());
        CompletableFuture.runAsync(()->SmallTool.printTimeAndThread("A"),executor)
                .thenRunAsync(()->SmallTool.printTimeAndThread("B"),executor)
                .join();
    }
}

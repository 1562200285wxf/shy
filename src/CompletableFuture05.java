import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class CompletableFuture05 {
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白和朋友进餐厅点菜");
        long startTime=System.currentTimeMillis();

        ArrayList<Dish> dishes=new ArrayList<>();
        for(int i=0;i<2;i++) {
            Dish dish=new Dish("菜" + i,1);
            dishes.add(dish);
        }

        ArrayList<CompletableFuture> cfList=new ArrayList<>();
        for(Dish dish:dishes) {
            //CompletableFuture.runAsync(()->dish.make()).join();
            CompletableFuture<Void> cf=CompletableFuture.runAsync(()->dish.make());
            cfList.add(cf);
        }

        //等待当前容器里所有任务执行完毕
        CompletableFuture.allOf(cfList.toArray(new CompletableFuture[cfList.size()])).join();

        SmallTool.printTimeAndThread("菜都做好了，上桌" + (System.currentTimeMillis() - startTime));
    }
}

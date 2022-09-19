import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TwoCarCrossBridge {
    public static void main(String[] args) {
        Thread carTwo = new Thread(() -> {
            SmallTool.printTimeAndThread("卡车2号 准备过桥");
            SmallTool.printTimeAndThread("发现1号在过，开始等待");
            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("卡车2号 开始过桥");
            }
            SmallTool.printTimeAndThread("卡车2号，过桥完毕");
        });

        Thread carOne = new Thread(() -> {
            SmallTool.printTimeAndThread("卡车1号，开始过桥");
            int timeSpend = new Random().nextInt(100) + 100;
            SmallTool.sleepMillis(timeSpend);
            SmallTool.printTimeAndThread("卡车1号，过桥完毕，耗时" + timeSpend);

            carTwo.interrupt();
        });

        carOne.start();
        carTwo.start();

    }
}

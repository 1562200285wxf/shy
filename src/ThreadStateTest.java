import java.util.concurrent.TimeUnit;

public class ThreadStateTest {
    public static void main(String[] args) {
        Thread thread=new Thread();
        System.out.println("1-" + thread.getState());
        thread.start();
        System.out.println("2-" + thread.getState());
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("4-" + thread.getState());
        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("产生中断" + e.getMessage());
        }
        System.out.println("3-" + thread.getState());
    }
}

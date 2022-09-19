import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static void main(String[] args) {
        Thread thread=new Thread() {
            @Override
            public void run() {
                System.out.println("new thread by override run()");
            }
        };
        thread.start();

        Thread thread1=new Thread(()-> System.out.println("new thread by Runnable interface"));
        thread1.start();

        Callable<String> callable=new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("callable interface call() methord");
                return "callable interface";
            }
        };
        FutureTask futureTask=new FutureTask(callable);
        Thread thread2=new Thread(futureTask);
        thread2.start();

        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("main end");

    }
}

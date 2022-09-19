public class ThreadInterruptedTest {
    public static void main(String[] args) {
        Thread carOne = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while(System.currentTimeMillis() - startTime < 20) {
                if(Thread.currentThread().isInterrupted()) {
                    SmallTool.printTimeAndThread("向左开1米");
                } else {
                    SmallTool.printTimeAndThread("向前开1米");
                }
            }
        });
        carOne.start();

        SmallTool.sleepMillis(1);
        carOne.interrupt();
    }
}

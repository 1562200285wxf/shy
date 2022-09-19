public class Test {
    public static void main(String[] args) {
        long max=Runtime.getRuntime().maxMemory();
        long total=Runtime.getRuntime().totalMemory();
        System.out.println((max/(double)1024/1024));
        System.out.println((total/(double)1024/1024));
    }
}

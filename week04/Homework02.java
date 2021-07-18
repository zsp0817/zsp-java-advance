import java.util.concurrent.ExecutionException;

/**
 * 主线程使用join
 */
public class Homework02 {

    private static int result = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        Runnable task = () -> {
            result = sum();
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.join();

        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}





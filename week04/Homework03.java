import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * 使用CountDownLatch
 */
public class Homework03 {

    private static int result = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        Runnable task = () -> {
            result = sum();
            countDownLatch.countDown();
        };
        Thread thread = new Thread(task);
        thread.start();
        countDownLatch.await();

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





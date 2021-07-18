import java.util.concurrent.*;

/**
 * 使用Callable
 */
public class Homework01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> {
            return sum();
        };

        Future<Integer> future = executor.submit(task);
        int result = future.get();
        executor.shutdown();

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




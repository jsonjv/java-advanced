package executors;

import streams.PartitioningElements;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html
// executor framework - simplifies threads manipulation
// doesn't handle concurrency issues such as race condition
public class ThreadPools {
    public static void show() {
        // return executor with a single thread
//        Executors.newSingleThreadExecutor();

        // create a thread pool with given number of worker threads
        // return an instance of ThreadPoolExecutor class
//        Executors.newFixedThreadPool();

        // returns an instance of ScheduledThreadPoolExecutor
//        Executors.newScheduledThreadPool();

        // executor - ExecutorService
        var executor = Executors.newFixedThreadPool(2);
        System.out.println(executor.getClass().getName()); // at runtime type will be ThreadPoolExecutor

//        for (int i = 0; i < 10; i++) {
//            executor.submit(() -> System.out.println(Thread.currentThread().getName()));
//        }

        // doesn't stop the current task, will wait for the completion of tasks, not accept any new task
//        executor.shutdown();

        // force existing tasks to stop
//        executor.shutdownNow();

        try {
            executor.submit(() -> System.out.println(Thread.currentThread().getName()));
        } finally {
            executor.shutdown();
        }
    }
}

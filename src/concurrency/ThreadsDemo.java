package concurrency;

public class ThreadsDemo {
    public static void show() {
        // returns active threads on the current process
        // 1 thread running main method, 1 background thread runs the garbage collector
        System.out.println(Thread.activeCount());

        // available threads
        // cpu cores - each core has 2 threads (cores * 2)
        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println(Thread.currentThread().getName());

//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(new DownloadFileTask());
//            thread.start();
//        }

        Thread thread = new Thread(new DownloadFileTask());
        thread.start();
    }
}

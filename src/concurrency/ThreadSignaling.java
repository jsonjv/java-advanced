package concurrency;

public class ThreadSignaling {
    public static void show() {
        var status = new DownloadStatus();

        var thread1 = new Thread(new DownloadFileTask(status));
        var thread2 = new Thread(() -> {
            // waste cpu cycles
//            while (!status.isDone()) {}

            while (!status.isDone()) {
                synchronized (status) {
                    try {
                        // first iteration, the wait method will put the while loop into sleep
                        // will not run (x) times, will wait for notify to avoid wasting cpu cycles
                        status.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }
}

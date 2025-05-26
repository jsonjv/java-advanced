package concurrency;

public class InterruptingThread {
    public static void show() {
        Thread thread = new Thread(new DownloadFileTask());
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // doesn't actually force thread to stop
        // sends an interrupt request to the thread
        thread.interrupt();
    }
}

package concurrency;

// https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html
public class DownloadFileTask implements Runnable {
    private final DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        // pausing a thread
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        for (int i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
//            System.out.println("Downloading byte " + i);
            status.incrementTotalBytes();
        }

        status.done();

        synchronized (status) {
            status.notifyAll();
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }
}

package concurrency;

public class JoiningThread {
    public static void show() {
        Thread thread = new Thread(new DownloadFileTask());
        thread.start();

        System.out.println("Main thread");

        // joining a thread
        try {
            // will make the current thread(main) wait for the completion of the thread(DownloadFileTask)
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("File is ready to be scanned.");
    }
}

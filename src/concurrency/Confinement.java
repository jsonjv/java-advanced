package concurrency;

import java.util.ArrayList;
import java.util.List;

public class Confinement {
    public static void show() {
        // confinement - restrict each thread to have its own data
        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> downloadFileTasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var task = new DownloadFileTask();
            downloadFileTasks.add(task);

            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        var totalBytes = downloadFileTasks.stream()
                .map(t -> t.getStatus().getTotalBytes())
                .reduce(0, Integer::sum);

        System.out.println("total bytes " + totalBytes);
    }
}

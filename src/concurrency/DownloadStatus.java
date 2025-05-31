package concurrency;

import streams.PartitioningElements;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    private final Lock lock = new ReentrantLock();

    private final Object totalBytesLock = new Object();

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
//        totalBytes++;

        // synchronization
        // - prevent multiple threads from accessing the same object concurrently using locks
        // - forces the code to run sequentially which against idea of concurrency
        // - implementation is challenging and error-prone
        // - deadlock - two threads waits for each other indefinitely
        // - bad and should avoid as much as possible

//        lock.lock();
//        try {
//            totalBytes++;
//        } finally {
//            // executes in a finally block to avoid deadlock if exception is thrown
//            lock.unlock();
//        }

        // avoid synchronized (this) block
//        synchronized (this) {
//            totalBytes++;
//        }

        // use a dedicated monitor obj
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    // same as synchronized (this) block
//    public synchronized void incrementTotalBytes() { }
}

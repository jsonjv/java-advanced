package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    // volatile - telling jvm this field is unstable it may change, don't rely on value stored in the cache, always read it from the memory
    // guaranteed the changes on the field is visible across threads
    private volatile boolean isDone;
//    private int totalBytes;
//    private AtomicInteger totalBytes = new AtomicInteger();
//    https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/LongAdder.html
    // if you have multiple threads updating a value frequently, prefer adder over atomic types
    private LongAdder totalBytes = new LongAdder();
//    private final Lock lock = new ReentrantLock();

    private final Object totalBytesLock = new Object();

    public int getTotalBytes() {
//        return totalBytes;

//        return totalBytes.get();

        return totalBytes.intValue(); // sum()
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
//        synchronized (totalBytesLock) {
//            totalBytes++;
//        }

        // multiple threads can modify this field concurrently without waiting for each other
        // atomic types - uses technique compare and swap, which supported by most CPUs
        // executed as a single uninterrupted operation

        // dealing with counter variables, prefer atomic types to synchronization, faster and easier to use

        // this atomic type will compare the current value with the expected value
        // if their not equal, it's going to swap them
        // e.g.
        // current value = 0. increment it, so expected value = 1
//        totalBytes.incrementAndGet();

        totalBytes.increment();
    }

    // same as synchronized (this) block
//    public synchronized void incrementTotalBytes() { }

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }
}

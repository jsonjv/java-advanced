package collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void show() {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("b");
        // b -> a -> c

        var front = queue.peek(); // return null if queue is empty
//        var front = queue.element(); // throws an exception if queue is empty
        System.out.println(front);

        var removed = queue.remove(); // throws an exception if empty
//        var removed = queue.poll(); // return null if empty
        System.out.println(removed);
        System.out.println(queue);

        queue.offer("d");
        // d -> b -> a -> c
    }
}

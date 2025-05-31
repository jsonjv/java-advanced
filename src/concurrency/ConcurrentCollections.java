package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// concurrent collections - classes uses the partitioning technique to achieve concurrency
// partitioning - partition data into segments that can be accessed concurrently
// faster than synchronize collection
public class ConcurrentCollections {
    public static void show() {
//        Map<Integer, String> map = new HashMap<>(); // not thread-safe
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "a");
        map.get(1);
        map.remove(1);
    }
}

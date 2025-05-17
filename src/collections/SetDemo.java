package collections;

import java.util.*;

public class SetDemo {
    public static void show() {
//        Set<String> set = new HashSet<>();
//        set.add("sky");
//        set.add("is");
//        set.add("blue");
//        set.add("blue");
//
//        System.out.println(set);

//        Collection<String> collection = new ArrayList<>();
//        Collections.addAll(collection, "a", "b", "c", "c");
//        Set<String> set = new HashSet<>(collection);
//
//        System.out.println(collection);
//        System.out.println(set);

        Set<String> set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> set2 = new HashSet<>(Arrays.asList("b", "c", "d"));

        // Union - combination of 2 sets
        set1.addAll(set2);
        System.out.println(set1);

        // Intersection - give items common in both sets
        set1.retainAll(set2);
        System.out.println(set1);

        // Difference - difference of 2 sets
        set1.removeAll(set2);
        System.out.println(set1);
    }
}

package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show() {
        Collection<String> collection = new ArrayList<>();

//        collection.add("a");
//        collection.add("b");
//        collection.add("c");
        Collections.addAll(collection, "a", "b", "c");
        collection.remove("b");
//        collection.clear();
        var containsA = collection.contains("a");

        System.out.println(collection);
        System.out.println(containsA);
        System.out.println(collection.isEmpty());

        Object[] objArr = collection.toArray();
        String[] strArr = collection.toArray(new String[0]);
        System.out.println(strArr[0].toUpperCase());

        Collection<String> other = new ArrayList<>();
        other.addAll(collection);

        System.out.println(collection == other);
        System.out.println(collection.equals(other));
    }
}

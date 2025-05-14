package generics;

public class Utils {
    public static <T extends Comparable<T>>T max(T first, T second) {
        return (first.compareTo(second) > 0) ? first : second;
    }

    public static <K, V> void print(K key, V value) {
        System.out.println(key + "=" + value);
    }

    public static void printUser(User user) {
        System.out.println(user);
    }

    // wildcard ? = unknown
    // class CAP#1 extends User {}
    // class Instructor extends User
    public static void printUsers(GenericList<? extends User> users) {
        // read from list, use extends
        User x = users.get(0);
    }

    public static void addUser(GenericList<? super User> users) {
        // add from list, use super
        users.add(new Instructor(20));
    }
}

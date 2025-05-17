package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {
    public static void show() {
//        List<Customer> customers = new ArrayList<>();
//
//        // O(n)
//        for (var customer : customers)
//            if (customer.getEmail().equals("e1"))
//                System.out.println("Found!");

        var customer1 = new Customer("a", "e1");
        var customer2 = new Customer("b", "e2");

        Map<String, Customer> map = new HashMap<>();
        map.put(customer1.getEmail(), customer1);
        map.put(customer2.getEmail(), customer2);

        var customer = map.get("e1");
        System.out.println(customer);

        var unknown = new Customer("unknown", "");

        var customerGetDefault = map.getOrDefault("e10", unknown);
        System.out.println(customerGetDefault);

        var exists = map.containsKey("e10");
        System.out.println(exists);

        map.replace("e1", new Customer("a++", "e1"));
        System.out.println(map);

        for (var key : map.keySet())
            System.out.println(key);

        for (var entry : map.entrySet()) {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // does not guarantee order
        for (var customerValue : map.values())
            System.out.println(customerValue);
    }
}

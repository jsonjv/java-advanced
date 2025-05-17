package collections;

import java.util.Comparator;

public class EmailComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        // this < other -> -1
        // this == other -> 0
        // this > other -> 1

        return o1.getEmail().compareTo(o2.getEmail());
    }
}

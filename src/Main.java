import generics.GenericList;
import generics.Instructor;
import generics.User;
import generics.Utils;

public class Main {
    public static void main(String[] args) {
        var user1 = new User(10);
        var user2 = new User(20);

        if (user1.compareTo(user2) < 0)
            System.out.println("user1 < user2");
        else if (user1.compareTo(user2) == 0)
            System.out.println("user1 == user2");
        else
            System.out.println("user1 > user2");

        System.out.println(Utils.max(new User(10), new User(20)));
        Utils.print(1, "Jason");

        User user = new Instructor(20);
        Utils.printUser(user);

        var instructors = new GenericList<Instructor>();
        var users = new GenericList<User>();
        Utils.printUsers(new GenericList<User>());
    }
}
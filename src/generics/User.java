package generics;

public class User implements Comparable<User> {
    private int points;

    public User(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(User o) {
        // this < o -> -1
        // this == o -> 0
        // this > o -> 1
//        if (points < o.points) return -1;
//        if (points == o.points) return 0;
//        return -1;

        return points - o.points;
    }

    @Override
    public String toString() {
        return "Points=" + points;
    }
}

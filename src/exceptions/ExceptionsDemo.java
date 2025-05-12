package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {
    public static void show() throws Throwable {
        // NullPointerException
        sayHello(null);

        var account = new Account();
        account.deposit(-1);

        try {
            account.withdraw(10);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
            var cause = e.getCause();
            System.out.println(cause.getMessage());
            e.printStackTrace();
        }
    }

    public static void sayHello(String name) {
        System.out.println(name.toUpperCase());
    }

    public static void catchingExceptions() {
        try (
            var reader = new FileReader("file.txt");
            var writer = new FileWriter("...");
        ) {
            var value = reader.read();
            new SimpleDateFormat().parse("");
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
        } catch (IOException | ParseException e) {
            System.out.println("Could not read data.");
        } finally {
            System.out.println("Finally block");
        }
    }
}

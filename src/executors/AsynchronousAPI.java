package executors;

public class AsynchronousAPI {
    public static void show() {
        var service = new MailService();
//        service.send(); // synchronous - thread-blocking method
        service.sendAsync(); // asynchronous - non-blocking

        System.out.println("Hello world");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

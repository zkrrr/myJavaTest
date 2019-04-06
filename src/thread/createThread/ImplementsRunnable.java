package thread.createThread;

public class ImplementsRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("This is my test to create a thread by implements Runnable.");
    }
}

class MyTest{
    public static void main(String[] args) {
        Thread thread = new Thread(new ImplementsRunnable());
        thread.start();
    }
}
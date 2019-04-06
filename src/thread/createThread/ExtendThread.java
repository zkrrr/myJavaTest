package thread.createThread;

public class ExtendThread extends Thread{
    @Override
    public void run() {
        System.out.println("This is my test to create a thread by extends Thread. ");
    }
}

class Test{
    public static void main(String[] args) {
        ExtendThread extendThread = new ExtendThread();
        extendThread.start();
    }
}
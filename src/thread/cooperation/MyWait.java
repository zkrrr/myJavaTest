package thread.cooperation;

class WaitThread implements Runnable{
    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName()+" thread start.");
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" thread end.");
    }
}
public class MyWait {
    public static void main(String[] args) {
        Thread thread = new Thread(new WaitThread());
        thread.start();
    }
}

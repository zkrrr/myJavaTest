package thread.cooperation;

class SleepThread implements Runnable{
    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName()+" thread start.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" thread end.");
    }
}

public class MySleep {
    public static void main(String[] args) {
        SleepThread sleepThread = new SleepThread();
        for (int i=0;i<5;i++){
            Thread thread = new Thread(sleepThread);
//            Thread thread = new Thread(new SleepThread());
            thread.start();
        }
    }
}

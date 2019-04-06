package thread.cooperation;

class YieldThread implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            Thread.yield();
        }
    }
}

public class MyYield {
    public static void main(String[] args) {
        YieldThread yieldThread = new YieldThread();
        Thread t1 = new Thread(yieldThread,"first");
        Thread t2 = new Thread(yieldThread,"second");
        t1.start();
        t2.start();
    }
}

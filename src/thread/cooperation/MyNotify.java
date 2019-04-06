package thread.cooperation;

class NotifyThread implements Runnable{
    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName()+" thread start.");
        try {
            wait(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" thread end.");
    }
}

public class MyNotify {
    public static void main(String[] args) {
        NotifyThread notifyThread = new NotifyThread();
        for (int i=0;i<5;i++){
            Thread thread = new Thread(notifyThread);
            thread.start();
        }
        synchronized (notifyThread) {
            notifyThread.notify();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------");
        synchronized (notifyThread) {
            notifyThread.notifyAll();
        }
    }
}

class TestNotify{
    public synchronized void testNotify(){
        System.out.println(Thread.currentThread().getName()+" thread start.");
        try {
            wait(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" thread end.");
    }

    public static void main(String[] args) {
        TestNotify testNotify = new TestNotify();
        for(int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testNotify.testNotify();
                }
            }).start();
        }
        synchronized (testNotify) {
            testNotify.notify();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------");
        synchronized (testNotify) {
            testNotify.notifyAll();
        }
    }
}
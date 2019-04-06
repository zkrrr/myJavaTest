package thread.cooperation;

class  JoinThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" thread start.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" thread end.");
    }
}
public class MyJoin {
    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            Thread thread = new Thread(new JoinThread());
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished~~~~");
    }
}

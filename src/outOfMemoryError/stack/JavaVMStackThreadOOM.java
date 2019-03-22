package outOfMemoryError.stack;

public class JavaVMStackThreadOOM {

    /*
     * -Xss256k
     * unable to create new native thread
     */
    private void doSomething(){
        while (true){

        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    doSomething();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackThreadOOM oom = new JavaVMStackThreadOOM();
        oom.stackLeakByThread();
    }
}

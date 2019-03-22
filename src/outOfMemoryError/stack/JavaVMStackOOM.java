package outOfMemoryError.stack;

public class JavaVMStackOOM {

    /*
     *-Xss256k 最小设置为228k
     */

    private int stackLength = -1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack lengh:" + oom.stackLength);
            throw  e;
        }
    }
}
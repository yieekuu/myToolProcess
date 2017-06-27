package liye.carlos.myToolProcess.worker;

/**
 * Created by liye3 on 2017/6/23.
 */
public class TestWork implements Runnable {

    @Override
    public void run() {
        go();
    }

    public void go() {
        doMore();
    }

    public void doMore() {
        System.out.println("top o' of the stack");
    }

}

class ThreadTestDrive {
    public static void main(String[] args) {
        Runnable threadJob = new TestWork();
        Thread thread = new Thread(threadJob);
        thread.start();
        System.out.println("back in main");
    }
}


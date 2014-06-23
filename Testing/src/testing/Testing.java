package testing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Testing implements Runnable {
    
    private static int instanceCount = 0;
    private final int currentInstance = instanceCount++;
    private int countDown = 5;
    
    @Override
    public String toString() {
        return Thread.currentThread() + " " + currentInstance;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Testing());
        }
        System.out.println("Started all threads");
        exec.shutdown();
        
        
    }
    
    @Override
    public void run() {
        while (true) {
            System.out.println(this + " Counting " + countDown);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (countDown-- == 0) {
                return;
            }
        }
    }
    
}

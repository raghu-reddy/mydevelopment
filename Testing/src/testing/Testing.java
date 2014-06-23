package testing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Testing implements Runnable {
    
    class SomeException extends Exception {}

    public static void main(String[] args) {
        try {
            System.out.println("in try");
            throw new SomeException();
        } catch (SomeException e) {
            System.out.println("In SomeException");
        } finally {
            System.out.println("In finally");
        }
        
        
    }
    
}

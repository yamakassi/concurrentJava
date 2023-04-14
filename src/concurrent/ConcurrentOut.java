package concurrent;

public class ConcurrentOut {
    public static void testOutputConcurrent(){
        Thread first = new Thread(
                ()-> System.out.println(String.format("fist: %s\n%s",Thread.currentThread().getName(),Thread.currentThread().getThreadGroup()))
        );
        first.start();
        Thread second = new Thread(
                ()-> System.out.println(String.format("second: %s\n%s",Thread.currentThread().getName(),Thread.currentThread().getThreadGroup()))
        );
        second.start();
        System.out.println(String.format("%s\n%s",Thread.currentThread().getName(),Thread.currentThread().getThreadGroup()));



    }
}

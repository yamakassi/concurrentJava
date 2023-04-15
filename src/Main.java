import concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       // System.out.println("Hello world!");

        //test1 запус нити
     //   ConcurrentOut.testOutputConcurrent();
        //test2 состояние
        // ConcurrentThreadState.stateThread();
        //test3
      //  ThreadSleep.threadSleep();

        //test4 anim
      /*  Thread anim = new Thread(new ConsoleProcessAnim());

        anim.start();
        Thread.sleep(1);
        Thread.interrupted();*/

        //test5 file read

        Thread load = new Thread(new FileThreadLoad("http://entropymine.com/jason/testbed/mime/html/file.txt",20));

        load.start();
        load.join();

    }
}
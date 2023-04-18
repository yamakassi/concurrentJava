package pool;

import wait.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class SimpleThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();

    public SimpleThreadPool() {
        int size = Runtime.getRuntime().availableProcessors();
        for(int i=0;i<size;i++){
            threads.add(new Thread(
                    ()->{
                        System.out.println(
                                "Поток " + Thread.currentThread().getName() + " начал работать"
                        );
                        while (!Thread.currentThread().isInterrupted()) {
                            try {
                                System.out.println(
                                        "Поток " + Thread.currentThread().getName() + " работает"
                                );

                                System.out.println(
                                        "Поток " + Thread.currentThread().getName() + " выполнил");
                                tasks.poll().run();

                            } catch (InterruptedException e) {
                                System.out.println(
                                        "Поток " + Thread.currentThread().getName() + " прерван"
                                );
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
            ));
        }
        for(Thread thread:threads) thread.start();
    }
    public void work(Runnable job) {
        tasks.offer(job);
    }
    private void shutdown() {
        for(Thread thread:threads){
            thread.interrupt();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        SimpleThreadPool pool = new SimpleThreadPool();
        pool.work(() -> System.out.println("work1"));
        pool.work(() -> System.out.println("work2"));
        pool.work(() -> System.out.println("work3"));
         pool.work(() -> System.out.println("work1"));
        pool.work(() -> System.out.println("work2"));
        pool.work(() -> System.out.println("work3"));
         pool.work(() -> System.out.println("work1"));
        pool.work(() -> System.out.println("work2"));
        pool.work(() -> System.out.println("work3"));
         pool.work(() -> System.out.println("work1"));
        pool.work(() -> System.out.println("work2"));
        pool.work(() -> System.out.println("work3"));
         pool.work(() -> System.out.println("work1"));
        pool.work(() -> System.out.println("work2"));
        pool.work(() -> System.out.println("work3"));
         pool.work(() -> System.out.println("work1"));
        pool.work(() -> System.out.println("work2"));
        pool.work(() -> System.out.println("work3"));
         pool.work(() -> System.out.println("work1"));
        pool.work(() -> System.out.println("work2"));
        pool.work(() -> System.out.println("work3"));
        pool.shutdown();
    }




}

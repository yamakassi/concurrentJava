package wait;

public class ParallelSearch {
    public static void main(String[] args) {
        SimpleBlockingQueue queue = new SimpleBlockingQueue();
        Thread consumer = new Thread(
                ()->{
                    while(!Thread.currentThread().isInterrupted()){
                        try {
                            System.out.println(queue.poll());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        consumer.start();
        Thread producer = new Thread(
                ()->{
                    for(int i=0; i<3;i++){
                        queue.offer(i);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        producer.start();
    }
}

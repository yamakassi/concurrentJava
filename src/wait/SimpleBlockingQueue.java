package wait;

import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;
@ThreadSafe
public class SimpleBlockingQueue<T> {
    private final Queue<T> queue = new LinkedList<>();
    public  synchronized  void offer(T elem){
        queue.offer(elem);
        notifyAll();
    }
    public synchronized T poll() throws InterruptedException {
        while (queue.isEmpty()){
            this.wait();
        }
        return queue.poll();

    }

}

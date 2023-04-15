package blocking;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASCount {
    private final AtomicReference<Integer> count = new AtomicReference<>(0);
    public void increment(){
        Integer v;
        do{
            v=count.get()+1;
        }while (count.compareAndSet(count.get(),v));
    }
    public int get() {
        return count.get();
    }

}




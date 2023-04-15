package wait;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class CountWait {

        private final Object monitor = this;
        private final int total;
        private int count = 0;

        public CountWait(final int total) {
            this.total = total;
        }

        public synchronized void count() {
            System.out.println(count++);
            monitor.notifyAll();
        }

        public synchronized void await() {
            while (count <= total) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Внутри await");
            }
        }
    }


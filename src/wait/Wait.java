package wait;

public class Wait {

    private boolean flag = false;

    private final Object monitor = this;

    public void on() {
        synchronized (monitor) {
            flag = true;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            monitor.notifyAll();
        }
    }

    public void off() {
        synchronized (monitor) {
            flag = false;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            monitor.notifyAll();
        }
    }

    public void check() {
        synchronized (monitor) {
            while (!flag) {
                try {
                    monitor.wait();
                    System.out.println("wait");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}


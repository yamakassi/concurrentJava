package multithreads;

public class SwitcherThread {
    public static void main(String[] args) throws InterruptedException {
        MasterSlaveBarrier barrier = new MasterSlaveBarrier();
        Thread first = new Thread(
                () -> {
                    barrier.tryMaster();
                    while (true) {
                        System.out.println("Thread A" );
                        try {
                            Thread.sleep(1000);
                           // barrier.downSlave();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
        );
        Thread second = new Thread(
                () -> {
                    barrier.downMaster();
                    barrier.trySlave();
                    while (true) {
                        System.out.println("Thread B" );
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
        );


        first.start();
        second.start();
        first.join();
        second.join();
    }
}

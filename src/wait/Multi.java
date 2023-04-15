package wait;

public class Multi {
    public static void main(String[] args) {
        Wait wait = new Wait();
        Thread master = new Thread(
                ()->{
                    System.out.println(Thread.currentThread().getName()+" started");
                    wait.on();
                },"Master"
        );
        Thread slave = new Thread(
                ()->{
                    wait.check();
                    System.out.println(Thread.currentThread().getName()+" started");

                },
                "Slave"
        );

      //  wait.off();
        //
        slave.start();
        master.start();
    }
}

package concurrent;

public class ThreadSleep {
    public static void  threadSleep(){
        Thread thread = new Thread(
                ()->{
                    try{
                        /*System.out.println("Loading...");
                        Thread.sleep(2000);
                        System.out.println("successful");*/
                        for(int i=0;i<101;i++){
                            System.out.println("\\rLoading: "+i+"%\n");
                            Thread.sleep(500);

                        }


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
        );
        thread.start();
        System.out.println("sleepThread");
    }
}

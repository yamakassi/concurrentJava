package multithreads;

public class MasterSlaveBarrier {
    private volatile  boolean isMasterWorking = true;



    public  synchronized void  tryMaster(){
        while(!isMasterWorking){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public  synchronized void  trySlave(){
        while(isMasterWorking){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void downMaster(){
        isMasterWorking=false;
        notifyAll();
    }
    public synchronized void downSlave(){
        isMasterWorking=true;
        notifyAll();
    }

}

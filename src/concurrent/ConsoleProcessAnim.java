package concurrent;

public class ConsoleProcessAnim implements Runnable {

    @Override
    public void run() {
        int count =0;
        char[] charProcess = new char[]{'/','|','\\'};
        try{
            while (!Thread.interrupted()){
                System.out.print("\rLoading ... " + charProcess[count++]);
                if(count>=charProcess.length){
                    count=0;
                }
                Thread.sleep(200);


            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

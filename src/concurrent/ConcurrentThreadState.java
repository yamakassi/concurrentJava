package concurrent;

public class ConcurrentThreadState {


        public static void stateThread(){
            Thread first = new Thread(
                    ()-> System.out.println(String.format("fist: %s\n%s",Thread.currentThread().getName(),Thread.currentThread().getThreadGroup()))
            );

            Thread second = new Thread(
                    ()-> System.out.println(String.format("second: %s\n%s",Thread.currentThread().getName(),Thread.currentThread().getThreadGroup()))
            );
            first.start();
            second.start();
            int i=0;
            while (
                    first.getState()!= Thread.State.TERMINATED
                     ||  second.getState() != Thread.State.TERMINATED
            ){
                System.out.println(i++);
            }
            System.out.println("Работа завершена");



        }


}

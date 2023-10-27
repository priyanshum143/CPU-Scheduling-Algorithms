import java.util.ArrayList;

public class App {
    public static void main(String[] args){
        ArrayList<Integer> arrivalTimes = new ArrayList<>();
        arrivalTimes.add(1);
        arrivalTimes.add(1);
        arrivalTimes.add(1);
        arrivalTimes.add(4);
        arrivalTimes.add(3);
        arrivalTimes.add(5);
        arrivalTimes.add(2);

        ArrayList<Integer> burstTimes = new ArrayList<>();
        burstTimes.add(5);
        burstTimes.add(11);
        burstTimes.add(1);
        burstTimes.add(8);
        burstTimes.add(6);
        burstTimes.add(10);
        burstTimes.add(8);

        info FCFS_algo = FCFS.info(arrivalTimes, burstTimes);
        System.out.println("Average Turn around time => " + FCFS_algo.avgTurnAroundTime);
        System.out.println("Average waiting around time => " + FCFS_algo.avgWaitTime);
    }
}
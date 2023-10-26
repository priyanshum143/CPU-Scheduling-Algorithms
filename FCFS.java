import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FCFS {
    private static final int START_TIME = 1;

    public static void AverageWaitTime(ArrayList<Integer> arrivalTimes, ArrayList<Integer> burstTimes){
        int numberOfProcesses = arrivalTimes.size();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<numberOfProcesses; i++){
            map.put(arrivalTimes.get(i), burstTimes.get(i));
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(numberOfProcesses);
        for(byte i=0; i<numberOfProcesses; i++){
            minHeap.add(arrivalTimes.get(i));
        }

        int currTime = START_TIME;
        int totalWaitingTime = 0;
        while(!minHeap.isEmpty()){
            int arrivalTime = minHeap.poll();
            int waitTime = currTime - arrivalTime;
            totalWaitingTime += waitTime;
            currTime += map.get(arrivalTime);
        }

        double avgWaitTime = totalWaitingTime / numberOfProcesses;
        System.out.println("Average Waiting Time = " + avgWaitTime);
    }
}
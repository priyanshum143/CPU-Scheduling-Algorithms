import java.util.ArrayList;

public class FCFS {
    // Function to find the idx of shortest job
    private static int findMin(ArrayList<Integer> arrivalTimes){
        int min = Integer.MAX_VALUE;
        int idx = 0;
        
        int size = arrivalTimes.size();
        for(int i=0; i<size; i++){
            if(arrivalTimes.get(i) < min){
                min = arrivalTimes.get(i);
                idx = i;
            }
        }
        return idx;
    }

    public static info info(ArrayList<Integer> arrivalTimes, ArrayList<Integer> burstTimes){
        int currTime = arrivalTimes.get(findMin(arrivalTimes));
        double totalWaitingTime = 0;
        double totalTurnAroundTime = 0;

        int numberOfProcesses = arrivalTimes.size();
        for(int i=0; i<numberOfProcesses; i++){
            int shortestJobIdx = findMin(arrivalTimes);
            int arrivalTime = arrivalTimes.get(shortestJobIdx);

            int waitTime = currTime - arrivalTime;
            totalWaitingTime += waitTime;

            currTime += burstTimes.get(shortestJobIdx);
            totalTurnAroundTime += currTime - arrivalTime;

            arrivalTimes.remove(shortestJobIdx);
            burstTimes.remove(shortestJobIdx);
        }

        info ans = new info();
        ans.avgWaitTime = totalWaitingTime / numberOfProcesses;
        ans.avgTurnAroundTime = totalTurnAroundTime / numberOfProcesses;
        return ans;
    }
}
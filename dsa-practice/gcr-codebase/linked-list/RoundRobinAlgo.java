import java.util.Scanner;
class ProcessNode{
    int pid;
    int burstTime;
    int remainingTime;
    int waitingTime;
    int turnaroundTime;
    ProcessNode next;
    ProcessNode(int pid, int burstTime){
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler{
    private ProcessNode head = null;
    private int processCount = 0;
    public void addProcess(int pid, int burstTime){
        ProcessNode newNode = new ProcessNode(pid, burstTime);
        if(head == null){
            head = newNode;
            newNode.next = head;
        } else {
            ProcessNode temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        processCount++;
    }

    //Display current process list
    public void displayProcesses(){
        if(head == null){
            System.out.println("No processes in the queue.");
            return;
        }
        ProcessNode temp = head;
        do {
            System.out.println("Process ID: " + temp.pid + ", Burst Time: " + temp.burstTime);
            temp = temp.next;
        } while(temp != head);
        System.out.println();
    }

    //Remove completed process
    public void removeProcess(ProcessNode prev , ProcessNode curr){
        if(curr == head && curr.next == head){
            head = null;
        } else {
            prev.next = curr.next;
            if(curr == head){
                head = curr.next;
            }
        }
        processCount--;
    }
    //Round Robin Scheuling Simulation
    public void roundRobinScheduling(int timeQuantum){
        int currentTime = 0;
        int totalwaitingTime = 0;
        int totalturnAroundTime = 0;
        int completed = 0;

        ProcessNode curr = head;
        ProcessNode prev = null;

        while(head != null){
            displayProcesses();

            if(curr.remainingTime > 0){
                int execTime = Math.min(curr.remainingTime, timeQuantum);
                curr.remainingTime -= execTime;
                currentTime += execTime;
            }

            if(curr.remainingTime == 0){
                curr.turnaroundTime = currentTime;
                curr.waitingTime = curr.turnaroundTime - curr.burstTime;
                totalwaitingTime += curr.waitingTime;
                totalturnAroundTime +=  curr.turnaroundTime;
                completed++;
                System.out.println("Process P " + curr.pid + " completed at time " + currentTime);
                removeProcess(prev, curr);
                curr = (prev == null) ? head : prev.next;
            }else{
                prev = curr;
                curr = curr.next;
            }

        }
        System.out.println("Average Waiting Time: " + (double)totalwaitingTime / completed);
        System.out.println("Average Turnaround Time: " + (double)totalturnAroundTime / completed);
    }
}

public class RoundRobinAlgo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.print("Enter Process ID for process " + (i+1) + ": ");
            int pid = sc.nextInt();
            System.out.print("Enter Burst Time for process " + (i+1) + ": ");
            int burstTime = sc.nextInt();
            scheduler.addProcess(pid, burstTime);
        }
        System.out.print("Enter Time Quantum: ");
        int timeQuantum = sc.nextInt();
        scheduler.roundRobinScheduling(timeQuantum);
        sc.close();
    }
}
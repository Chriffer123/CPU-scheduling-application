


import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int choice = 0;
    
    while (choice != 3) {
      System.out.println("\t1. First come First serve (FCFS)'");
      System.out.println("\t2. SJF (Non - preemptive)'");
      System.out.println("\t3.Priority (NON-preemptive");
      System.out.println("4. Exit");
      System.out.print("Enter your choice: ");

      choice = sc.nextInt();

      if (choice == 1) {
             int numProcesses;
        int[] arrivalTimes;
        int[] burstTimes;

        // Get the number of processes from the user
        System.out.print("Enter the number of processes: ");
        numProcesses = sc.nextInt();

        // Initialize the arrays for arrival times and burst times
        arrivalTimes = new int[numProcesses];
        burstTimes = new int[numProcesses];

        // Get the arrival times and burst times for each process from the user
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter the arrival time for process " + (i+1) + ": ");
            arrivalTimes[i] = sc.nextInt();
            System.out.print("Enter the burst time for process " + (i+1) + ": ");
            burstTimes[i] = sc.nextInt();
        }

        // Calculate the waiting times, turnaround times, and completion times for each process
        int[] waitingTimes = new int[numProcesses];
        int[] turnaroundTimes = new int[numProcesses];
        int[] completionTimes = new int[numProcesses];
        waitingTimes[0] = 0;
        turnaroundTimes[0] = burstTimes[0];
        completionTimes[0] = arrivalTimes[0] + burstTimes[0];
        for (int i = 1; i < numProcesses; i++) {
            waitingTimes[i] = completionTimes[i-1] - arrivalTimes[i];
            turnaroundTimes[i] = waitingTimes[i] + burstTimes[i];
            completionTimes[i] = arrivalTimes[i] + turnaroundTimes[i];
        }

        // Calculate the average waiting time and average turnaround time
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        for (int i = 0; i < numProcesses; i++) {
            totalWaitingTime += waitingTimes[i];
            totalTurnaroundTime += turnaroundTimes[i];
        }
        double avgWaitingTime = (double) totalWaitingTime / numProcesses;
        double avgTurnaroundTime = (double) totalTurnaroundTime / numProcesses;

        // Print the results
        System.out.println("Process\tArrival Time\tBurst Time\tCompletion Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < numProcesses; i++) {
            System.out.println((i+1) + "\t\t" + arrivalTimes[i] + "\t\t" + burstTimes[i] + "\t\t" + completionTimes[i] + "\t\t" + waitingTimes[i] + "\t\t" + turnaroundTimes[i]);
        }
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
      }  else if(choice == 2 ){
        int numProcesses;
        int[] arrivalTimes;
        int[] burstTimes;

        // Get the number of processes from the user
        System.out.print("Enter the number of processes: ");
        numProcesses = sc.nextInt();

        // Initialize the arrays for arrival times and burst times
        arrivalTimes = new int[numProcesses];
        burstTimes = new int[numProcesses];

        // Get the arrival times and burst times for each process from the user
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter the arrival time for process " + (i+1) + ": ");
            arrivalTimes[i] = sc.nextInt();
            System.out.print("Enter the burst time for process " + (i+1) + ": ");
            burstTimes[i] = sc.nextInt();
        }

        // Sort the processes by arrival time
        for (int i = 0; i < numProcesses - 1; i++) {
            for (int j = 0; j < numProcesses - i - 1; j++) {
                if (arrivalTimes[j] > arrivalTimes[j + 1]) {
                    // Swap arrival times
                    int temp = arrivalTimes[j];
                    arrivalTimes[j] = arrivalTimes[j + 1];
                    arrivalTimes[j + 1] = temp;
                    // Swap burst times
                    temp = burstTimes[j];
                    burstTimes[j] = burstTimes[j + 1];
                    burstTimes[j + 1] = temp;
                }
            }
        }

        // Calculate the waiting times, turnaround times, and completion times for each process
        int[] waitingTimes = new int[numProcesses];
        int[] turnaroundTimes = new int[numProcesses];
        int[] completionTimes = new int[numProcesses];
        waitingTimes[0] = 0;
        turnaroundTimes[0] = burstTimes[0];
        completionTimes[0] = arrivalTimes[0] + burstTimes[0];
        for (int i = 1; i < numProcesses; i++) {
            waitingTimes[i] = completionTimes[i-1] - arrivalTimes[i];
            turnaroundTimes[i] = waitingTimes[i] + burstTimes[i];
            completionTimes[i] = arrivalTimes[i] + turnaroundTimes[i];
        }

        // Calculate the average waiting time and average turnaround time
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        for (int i = 0; i < numProcesses; i++) {
            totalWaitingTime += waitingTimes[i];
            totalTurnaroundTime += turnaroundTimes[i];
        }
        double avgWaitingTime = (double) totalWaitingTime / numProcesses;
        double avgTurnaroundTime = (double) totalTurnaroundTime / numProcesses;

        // Print the results
        System.out.println("Process\tArrival Time\tBurst Time\tCompletion Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < numProcesses; i++) {
            System.out.println((i+1) + "\t\t" + arrivalTimes[i] + "\t\t" + burstTimes[i] + "\t\t" + completionTimes[i] + "\t\t" + waitingTimes[i] + "\t\t" + turnaroundTimes[i]);
        }
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
      } else if (choice == 3) {
          int n; // number of processes
        int[] arrivalTime; // arrival times of processes
        int[] burstTime; // burst times of processes
        int[] priority; // priority numbers of processes
        int[] waitingTime; // waiting time of processes
        int[] turnAroundTime; // turn around time of processes

        // read input from user
        System.out.print("Enter the number of processes: ");
        n = sc.nextInt();

        arrivalTime = new int[n];
        burstTime = new int[n];
        priority = new int[n];
        waitingTime = new int[n];
        turnAroundTime = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter arrival time of process " + (i+1) + ": ");
            arrivalTime[i] = sc.nextInt();
            System.out.print("Enter burst time of process " + (i+1) + ": ");
            burstTime[i] = sc.nextInt();
            System.out.print("Enter priority of process " + (i+1) + ": ");
            priority[i] = sc.nextInt();
        }

        // calculate waiting time and turn around time for each process
        for (int i = 0; i < n; i++) {
            waitingTime[i] = 0;
            for (int j = 0; j < i; j++) {
                waitingTime[i] += burstTime[j];
            }
            waitingTime[i] -= arrivalTime[i];
            turnAroundTime[i] = waitingTime[i] + burstTime[i];
        }

        // calculate average waiting time and average turn around time
        double AWT = 0;
        double ATT = 0;
        for (int i = 0; i < n; i++) {
            AWT += waitingTime[i];
            ATT += turnAroundTime[i];
        }
        AWT /= n;
        ATT /= n;

        // print results
        System.out.println("Process\tArrival Time\tBurst Time\tPriority\tWaiting Time\tTurn Around Time");
        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + "\t\t" + arrivalTime[i] + "\t\t" + burstTime[i] + "\t\t" + priority[i] + "\t\t" + waitingTime[i] + "\t\t" + turnAroundTime[i]);
        }
        System.out.println("Average Waiting Time: " + AWT);
        System.out.println("Average Turn Around Time: " + ATT);
      } else if (choice == 4) {
        System.out.println("Exiting...");
      } else {
        System.out.println("Invalid choice. Please try again.");
      }
    }

    sc.close();
  }
}








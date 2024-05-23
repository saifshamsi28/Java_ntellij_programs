package DAA_Concepts;
import java.util.Scanner;
class Job {
    char id;
    int deadline;
    int profit;
    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
class JobSequencing {
    public static void sortJobs(Job[] jobs) {
        for (int i = 0; i < jobs.length - 1; i++) {
            for (int j = 0; j < jobs.length - i - 1; j++) {
                if (jobs[j].profit < jobs[j + 1].profit) {
                    Job temp = jobs[j];
                    jobs[j] = jobs[j + 1];
                    jobs[j + 1] = temp;
                }
            }
        }
    }
    public static int scheduleJobs(Job[] jobs) {
        sortJobs(jobs);
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }
        Job[] slots = new Job[maxDeadline];
        int totalProfit = 0;
        for (Job job : jobs) {
            for (int i = job.deadline - 1; i >= 0; i--) {
                if (slots[i] == null) {
                    slots[i] = job;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        System.out.println("The scheduled jobs are:");
        for (Job job : slots) {
            if (job != null) {
                System.out.print(job.id + " ");
            }
        }
        System.out.println();
        return totalProfit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of jobs: ");
        int numJobs = sc.nextInt();
        Job[] jobs = new Job[numJobs];
        for (int i = 0; i < numJobs; i++) {
            System.out.println("Enter details for job " + (i + 1) + ":");
            System.out.println("Enter the job name: ");
            char jobName = sc.next().charAt(0);
            System.out.println("Enter the job deadline: ");
            int jobDeadline = sc.nextInt();
            System.out.println("Enter the job profit: ");
            int jobProfit = sc.nextInt();
            jobs[i] = new Job(jobName, jobDeadline, jobProfit);
        }
        int maxProfit = scheduleJobs(jobs);
        System.out.println("The maximum profit is: " + maxProfit);
    }
}

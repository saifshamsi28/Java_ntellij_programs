package BankersAlgorithm;

import java.util.Scanner;
class BankersAlgorithm{
    //method to calculate the resources need for each process
    static void findNeedValue(int needArray[][], int maxArray[][], int allocationArray[][], int totalProcess, int totalResources){
        // calculating Need for each process
        for (int i = 0 ; i < totalProcess ; i++){
            for (int j = 0 ; j < totalResources ; j++){
                needArray[i][j] = maxArray[i][j] - allocationArray[i][j];
            }
        }
    }
    //method to determine whether the system is in safe state or not
    static boolean checkSafeSystem(int processes[], int availableArray[], int maxArray[][], int allocationArray[][], int totalProcess, int totalResources){
        int [][]needArray = new int[totalProcess][totalResources];

        // call findNeedValue() method to calculate needArray
        findNeedValue(needArray, maxArray, allocationArray, totalProcess, totalResources);

        // all the process should be unfinished in starting
        boolean []finishProcesses = new boolean[totalProcess];

        // Array that store safe sequenced
        int []safeSequenceArray = new int[totalProcess];

        //workArray as a copy of the available resources
        int []workArray = new int[totalResources];

//        copy each available resource in the workArray
        for (int i = 0; i < totalResources ; i++)
            workArray[i] = availableArray[i];

        // initialize counter variable whose value will be 0 when the system is not in the safe state or when all the processes are not finished.
        int counter = 0;
        while (counter < totalProcess)
        {
            boolean foundSafeSystem = false;
            for (int m = 0; m < totalProcess; m++)
            {
                if (finishProcesses[m] == false)       // when process is not finished
                {
                    int j;
                    //check whether the need of each process for all the resources is less than the work
                    for (j = 0; j < totalResources; j++)
                        if (needArray[m][j] > workArray[j])
                            break;
                    // the value of J and totalResources will be equal when all the needs of current process are satisfied
                    if (j == totalResources)
                    {
                        for (int k = 0 ; k < totalResources ; k++)
                            workArray[k] += allocationArray[m][k];

                        // add current process in the safeSequenceArray
                        safeSequenceArray[counter++] = m+1;

                        // make this process finished
                        finishProcesses[m] = true;

                        foundSafeSystem = true;
                    }
                }
            }
            // the system will not be in the safe state when the value of the foundSafeSystem is false
            if (foundSafeSystem == false)
            {
                System.out.print("The system is not in the safe state because of lack of resources");
                return false;
            }
        }
        // printing the safe state sequence
        System.out.print("The system is in safe state sequence and the sequence is : ");
        for (int i = 0; i < totalProcess ; i++)
            System.out.print("P"+safeSequenceArray[i] + " ");
        return true;
    }

    public static void main(String[] args)
    {
        int numberOfProcesses, numberOfResources;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of processes: ");
        numberOfProcesses = sc.nextInt();
        System.out.print("Enter total number of resources: ");
        numberOfResources = sc.nextInt();

        //initialising process number to "processes" array
        int processes[] = new int[numberOfProcesses];
        for(int i = 0; i < numberOfProcesses; i++){
            processes[i] = i+1;
        }
        int availableArray[] = new int[numberOfResources];
        //giving the available numbers of each resources
        for( int i = 0; i < numberOfResources; i++){
            System.out.println("Enter the availability of resource_"+ (i+1) +": ");
            availableArray[i] = sc.nextInt();
        }
        int maxArray[][] = new int[numberOfProcesses][numberOfResources];
        // entering the maximum need of each resources for each processes
        for( int i = 0; i < numberOfProcesses; i++){
            for( int j = 0; j < numberOfResources; j++){
                System.out.println("Enter the maximum resource_"+ (j+1) +" that can be allocated to process_P"+ (i+1) +": ");
                maxArray[i][j] = sc.nextInt();
            }
        }
        int allocationArray[][] = new int[numberOfProcesses][numberOfResources];
        // giving how many instances of each resources are allocated
        for( int i = 0; i < numberOfProcesses; i++){
            for( int j = 0; j < numberOfResources; j++){
                System.out.println("How many instances of resource_"+ (j+1) +" are allocated to process_P"+ (i+1));
                allocationArray[i][j] = sc.nextInt();
            }
        }
        // method to check whether the system is in safe state or not
        checkSafeSystem(processes, availableArray, maxArray, allocationArray, numberOfProcesses, numberOfResources);
    }
}
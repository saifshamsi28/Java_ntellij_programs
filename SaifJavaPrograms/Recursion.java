package SaifJavaPrograms;

import java.util.Scanner;
public class Recursion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n=sc.nextInt();
        System.out.println("factorial of "+n+" is : "+Recursion(n));
    }
    public static int Recursion(int n){
        if(n==0){
            return 1;
        }
        else
            return n*Recursion(n-1);
    }
}

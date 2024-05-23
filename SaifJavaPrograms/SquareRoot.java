package SaifJavaPrograms;

import java.util.Scanner;
public class SquareRoot {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        double i,n,sqrt;
        System.out.print("Enter a number : ");
        n=s.nextFloat();
        for(i=0.00001;i*i<=n;i=i+0.00001);
        sqrt=i;

        System.out.printf("Square root of %.2f is : %.2f\n",n,sqrt);
        System.out.printf("Square root of %.2f using 'sqrt()' function : %.2f",n,Math.sqrt(n));

//        char a='a';
//        System.out.println(++a);
    }
}

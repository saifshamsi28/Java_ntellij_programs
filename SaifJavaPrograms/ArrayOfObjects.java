package SaifJavaPrograms;

import java.util.Scanner;

class Student{
    String name;
    int age;
    int marks=0;
    Student(String name,int age,int marks){
        this.name=name;
        this.age=age;
        this.marks=marks;
    }
}

public class ArrayOfObjects {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of object array: ");
        int size= sc.nextInt();
        Student [] students=new Student[size]; // array of object of Student-class
        for (int i=0;i<students.length;i++){
            System.out.print("Enter the name of Student "+(i+1)+" : ");
            String name=sc.next();
            System.out.print("Enter the age of Student "+(i+1)+" : ");
            int age=sc.nextInt();
            System.out.print("Enter the marks of Student "+(i+1)+" : ");
            int marks=sc.nextInt();
            students[i]=new Student(name,age,marks);
        }
        for (Student st:students){
            System.out.println("Hi i m "+st.name+" and i m "+ st.age +" years old and i got "+st.marks+" marks");
//            System.out.println(st.age);
        }
    }
}

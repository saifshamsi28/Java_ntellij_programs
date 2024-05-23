package StackDataStructure;
import java.util.ArrayList;
import java.util.Scanner;

public class StackUsingArrayList {
    static class Stack{
        static ArrayList<Integer> stack=new ArrayList<>();
        public static boolean isEmpty(){
            return stack.size()==0;  // or u can use "stack.isEmpty()" method
        }
        // push operation
        public static void push(int data){
            stack.add(data);
        }

        // pop operation
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            else {
                int topElement = stack.get(stack.size() - 1);
                stack.remove(stack.size() - 1);
                return topElement;
            }
        }
        // peek operation
        public static int peek(){
            if (isEmpty()){
                return -1;
            }
            else
                return stack.get(stack.size() - 1);
        }
        public static void printStack(){
            if(stack.isEmpty()){
                System.out.println("!! Currently no element in the stack !!");
            }
            else {
                System.out.println("Elements in the stack:- ");
                for (int a : stack) {
                    System.out.print(a + " ");
                }
            }
        }
    }
    public static void main(String[] s){
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("\n1.Push");
            System.out.println("2.Pop");
            System.out.println("3.Peek");
            System.out.println("4.Print elements of stack");
            System.out.println("5.Exit program");
            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();
            switch (choice){
                case 1->{
                    System.out.print("Enter the value you want to insert: ");
                    int data=sc.nextInt();
                    Stack.push(data);
                }
                case 2->{
                    int top=Stack.pop();
                    if(top==-1){
                        System.out.println("!! Stack is empty !!");
                    }
                    else {
                        System.out.println("Element " + top + " is popped");
                    }
                }
                case 3->{
                    int peekElement=Stack.peek();
                    if(peekElement==-1){
                        System.out.println("!! Stack is empty !!");
                    }
                    else {
                        System.out.println("Element " + peekElement + " is at the top of stack");
                    }
                }
                case 4->{
                    Stack.printStack();
                }
                case 5->{
                    System.out.println("!! you have successfully exited the program !!");
                    System.exit(0);
                }
                default ->
                    System.out.println("!! Invalid choice !!");
            }
        }
    }
}

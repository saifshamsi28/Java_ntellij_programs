package Bank;

import java.util.Scanner;
class bank {
    private String accountHolderName;
    private String accountNumber,ATMcardNumber;
    int ATMpin;
    private float currentBalance;
    public bank(String name,String accNumber,String cardNumber,float currentBalance,int pin){
        accountHolderName=name;
        accountNumber=accNumber;
        ATMcardNumber=cardNumber;
        this.currentBalance=currentBalance;
        ATMpin=pin;
    }
    public void DepositAmount(float amount){
        currentBalance+=amount;
    }
    public void WithdrawAmount(float amount){
        if(amount<=currentBalance){
            currentBalance-=amount;
        }
        else{
            System.out.println("\n!!Insufficient Balance!!");
        }
    }
    public void CheckBalance(){
        System.out.println("Current Balance = "+currentBalance);
    }
    public void Display(){
        System.out.println("    -:Account holder's details:-");
        System.out.println("Account Holder's Name: "+accountHolderName);
        System.out.println("Account Number: "+accountNumber);
        System.out.println("ATM card Number: "+ATMcardNumber);
        System.out.println("Account Balance: "+currentBalance);
    }
    public String getATMcardNumber(){
        return ATMcardNumber;
    }
    public int getATMpin(){
        return ATMpin;
    }
}
class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean ch=true;
        System.out.println("Enter Account holder name: ");
        String name=sc.nextLine();
        System.out.println("Enter Account number: ");
        String accNumber=sc.nextLine();
        System.out.println("Enter ATM card Number: ");
        String cardNumber=sc.nextLine();
        System.out.println("Enter ATM pin: ");
        int atmPin=sc.nextInt();
        System.out.println("Enter Account balance : ");
        float balance=sc.nextFloat();
        bank bank=new bank(name,accNumber,cardNumber,balance,atmPin);
        System.out.println("Welcome to Indian Overseas Bank");
        System.out.println("Enter ATM card number: ");
        String validATM=sc.next();

        if(validATM.equals(bank.getATMcardNumber())){
            System.out.println("Enter ATM pin: ");
            int pin=sc.nextInt();
            if(pin==bank.getATMpin()) {
                while (ch) {
                    System.out.println("1.Deposit Amount\n2.Withdraw Cash\n3.Check Balance\n4.Display Account Details\n5.Exit ");
                    System.out.println("Enter your Choice");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter Amount you want to deposit: ");
                            float amt = sc.nextFloat();
                            bank.DepositAmount(amt);
                        }
                        case 2 -> {
                            System.out.println("Enter amount you want to withdraw: ");
                            float amt = sc.nextFloat();
                            bank.WithdrawAmount(amt);
                        }
                        case 3 -> bank.CheckBalance();
                        case 4 -> bank.Display();
                        case 5 -> ch = false;
                        default -> System.out.println("!!Enter a valid choice!!");
                    }
                }
            }
            else{
                System.out.println("!!Wrong pin!!");
            }
        }
        else{
            System.out.println("\nNo account details found to this ATM card number");
        }
    }
}
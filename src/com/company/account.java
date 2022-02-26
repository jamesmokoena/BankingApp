package com.company;

import java.util.Scanner;

public class account {

    //class variables
    int Balance;
    int PreviousTransaction;
    String customerName;
    String CustomerId;
    String CustomerEmail;

    //class constructor
    account(String c_Name, String c_Id){
        customerName = c_Name;
        CustomerId = c_Id;

    }
    // method for making a deposit.
    void deposit(int amount){
     if (amount !=0 ){
         Balance = Balance + amount;
         PreviousTransaction = amount;

     }
    }
    //method for making a withdrawal.
    void withdrawal(int amount){
        if (amount !=0){
            Balance = Balance - amount;
            PreviousTransaction = amount;
        }
    }
    //method for displaying previous transaction.
    void oldTransaction(){
        if (PreviousTransaction > 0) {
            System.out.println("Deposited: " + PreviousTransaction);

        }else if (PreviousTransaction < 0){
            System.out.println("Withdrawal: "+ Math.abs(PreviousTransaction));
        }else{
            System.out.println("You did not make a transaction");
        }

    }
    //method for calculating the interest.
    void calculateInterest(int years){
        double interestRate = 1.2345;
        double newbalance = (Balance * interestRate * years) + Balance;
        System.out.println("The current interest is " + (100 * interestRate)+ "%");
        System.out.println("After " + years + " years your balance will be "+newbalance);

    }
    //method for the menu display
    void menu(){
        char option = '\0';
        Scanner scan = new Scanner(System.in);
        System.out.println(customerName + " Welcome to the CentralBankJoburg");
        System.out.println("This is your ID " + CustomerId);
        System.out.println();
        System.out.println("How can we help you today");
        System.out.println();
        System.out.println("A. Check your current balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transcation");
        System.out.println("E. Calculate interest");
        System.out.println("F. To exit ");

        do {
            System.out.println();
            System.out.println("Enter your option");
            char option1 = scan.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option){

                case 'A':
                    System.out.println("-------------------------------");
                    System.out.println("Balance = R"+ Balance);
                    System.out.println("-------------------------------");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit");
                    int amount = scan.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter an amount you want to withdraw");
                    int amount2 = scan.nextInt();
                    withdrawal(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("-------------------------------");
                    oldTransaction();
                    System.out.println("-------------------------------");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter number of years of acrued interest");
                    int years = scan.nextInt();
                    calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("----------------------------");
                    break;
                default:
                    System.out.println("Error: Invalid option. Your options are A,B,C,D,E.F");
                    break;
            }

        }while (option != 'F');
        System.out.println("Thank you for banking with us!");

    }
}


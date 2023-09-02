import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    //yet to know what the checking and saving balance does
    private double checkingBalance= 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###, ##0.00");

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getPinNumber(){
        return pinNumber;
    }

    public int setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }
    // No setters for saving balance and checking balance
    // because it is auto generated.

    // Created a method to do the operation
//    /It's excuting the withdrawal account for boht the saving and checking

//    Then it does the operation
    public double calCheckingWithdraw(double amount){
        // here we are subtracting whatever amount the customer wants to withdraw
        checkingBalance = (checkingBalance - amount);
        //It then returns the new balance
        return checkingBalance;
    }
    public double calSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calCheckingDeposit(double amount){
    checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }
    public double calSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    //After the operation has been done either for the savings or the checking, we .....
    public void getCheckingWithdrawInput(){
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Account: ");

        //Allows the user to input the amount, just like the scanner input
        double amount = input.nextDouble();

        // We check if the amount that the customer wants
        // to withdraw is smaller than the current balance or not

        if ((checkingBalance - amount) >= 0){
            //If it's smaller than we call the calCheckingWithdraw Method
            calCheckingWithdraw(amount);

            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance Cannot be Negative");
        }
    }
    public void getSavingWithdrawInput(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from Savings Account: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0){
            calSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance Cannot be Negative");
        }
    }

    public void getCheckingDepositInput(){
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to Deposit from Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance + amount) >= 0){
            calCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance Cannot be Negative");
        }

    }

    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to Deposit from Savings Account: ");
        double amount = input.nextDouble();

        if ((savingBalance + amount) >= 0){
            calSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance Cannot be Negative" + "\n");
        }
    }
}


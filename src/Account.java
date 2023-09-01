import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    //yet to know what the checking and saving balance does
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###, ##0.00, #.00");

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
//    /It's excuting the withdrawal account for boht the saving and checking'
    public double calCheckingWithdraw(double amount){
        checkingBalance = (checkingBalance - amount);
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
    public void getsheckingWithdrawInput(){
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Account: ");
        double amount = input.nextDouble();
    }
    public void getsavingWithdrawInput(){

    }
}


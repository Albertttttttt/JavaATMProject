import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

  public class OptionMenu  extends Account {
      Scanner userInput = new Scanner(System.in);
      // maximum of two decimal place, or if less than two, it'll replace with a zero
      DecimalFormat moneyFormat = new DecimalFormat("'$'###, ##0.00");

      // A hashmap object called "data" that stores Integer keys
      //also storing records of account number to pin mapping
      HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();


      public void getLogin() throws IOException {
          int x = 1;

          do {
              try {
                  //you put an integer key, and an integer value
                  // first interger to the customer number and the second to the customer pin number
                  data.put(123, 0000);
                  data.put(1234, 1111);

                  //So when we call the getLogin method, it will insert
                  //the data then ask the customer to put in his details
                  System.out.println("Welcome to the ATM Project");
                  System.out.println("Enter your customer Number");
                  //Here the user inputs his/her Customer Number
                  //The setters enable the user to set the setters
                  setCustomerNumber(userInput.nextInt());

                  System.out.println("Enter your PIN Number: ");
                  //Here the user inputs his/her Pin Number
                  setPinNumber(userInput.nextInt());
              } catch (Exception e) {
                  System.out.println("Invalid Character(s). Only Numbers.");
                  x = 2;
              }
              // if the data matches the pin number and the customer number,
              // get into the account type method
              // Right here we are fetching the values. the getters
              int cn = getCustomerNumber();
              int pn = getPinNumber();

              //the .containsKey() method is used to check whether a particular
//            key is being mapped into the hashMap or not.
              if (data.containsKey(cn) && data.containsKey(pn)) {
                  getAccountType();
              }
              if (data.get(cn) == pn) {
                  getAccountType();
              } else {
                  System.out.println("Wrong Customer Number or Pin Number");
              }


          } while (x == 1);
      }

      //This is the account type Method
      private void getAccountType() {
          System.out.println("Select the Account you want to Access: ");
          System.out.println("Type 1 - Checking Account ");
          System.out.println("Type 2 - Savings Account ");
          System.out.println("Type 3 - Exit ");

//        Then we allow the user to pick, just like the scanner - new scanner shit
//        getAccountType(userInput.nextInt());
          int selection = userInput.nextInt();

          //whatever secletion a user picks (userInput.nextInt()),
          // it goes into the switch statement.
          // Allowing the user to choose what to pick after choosing an account type

          switch (selection) {
              case 1 -> getCheckingAccount();
              case 2 -> getSavingAccount();
              case 3 -> System.out.println("Thank you for using this ATM!, Bye. \n");
              default -> {
                  System.out.println("Invalid Choice");
                  getAccountType();
              }
          }
      }

      //We have now created a method for checking Account
      public double getCheckingAccount() {
          System.out.println("Checking Account: ");
          System.out.println("Type 1 - View Balance ");
          System.out.println("Type 2 - Withdraw Funds");
          System.out.println("Type 3 - Deposit Funds");
          System.out.println("Type 4 - Exit");
          System.out.println("Choice: ");

          int selection = userInput.nextInt();

          switch (selection) {
              case 1 -> {
                  System.out.println("Checking Account Balance: " +
                          moneyFormat.format(getCheckingAccount()));
                  getAccountType();
                  //created two methods for both withdrawal and deposit of funds
              }
              case 2 -> {
                  getCheckingWithdrawInput();
                  getAccountType();
              }
              case 3 -> {
                  getCheckingDepositInput();
                  getAccountType();
              }
              case 4 -> System.out.println("Thank you for using this ATM!, Bye. \n");
              default -> {
                  System.out.println("Invalid Choice");
                  getAccountType();
              }
          }

         return 0;
      }

      public double getSavingAccount() {
          System.out.println("Savings Account: ");
          System.out.println("Type 1 - View Balance ");
          System.out.println("Type 2 - Withdraw Funds");
          System.out.println("Type 3 - Deposit Funds");
          System.out.println("Type 4 - Exit");
          System.out.println("Choice: ");

          int selection = userInput.nextInt();
          switch (selection) {
              case 1 -> System.out.println("Checking Savings Account Balance" +
                      moneyFormat.format(getSavingAccount()));
              case 2 -> {
                  getSavingWithdrawInput();
                  getAccountType();
              }
              case 3 -> {
                  getSavingDepositInput();
                  getAccountType();
              }
              case 4 -> System.out.println("Thank you for using this ATM!, Bye. \n");
              default -> {
                  System.out.println("Invalid Choice");
                  getAccountType();
              }
          }


          return 0;
      }
  }








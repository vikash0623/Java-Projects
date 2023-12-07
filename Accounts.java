package ATMmachine;
import java.util.Scanner;
class ATM {
    float Balance;
    int PIN = 7001;

    public void checkPin() {
        System.out.println("Enter your pin: ");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();
        if (enteredPin == PIN) {
            menu();
        } else {
            System.out.println("Enter a valid pin");
        }
    }

    public void menu() {
        System.out.println("Enter Your Choice: ");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposite Money");
        System.out.println("4. Change Your ATM Pin");
        System.out.println("5. Exit");


        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();
        if (opt == 1) {
            checkBalance();
        } else if (opt == 2) {
            withdrawMoney();
        } else if (opt == 3) {
            depositMoney();
        } else if (opt == 4) {
            changePin();  // Call the method to change the PIN
        } else {
            System.out.println("Enter a valid choice");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + Balance);
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter Amount to Withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > Balance) {
            System.out.println("Insufficient Balance");
        } else {
            Balance = Balance - amount;
            System.out.println("Money Withdrawl Successful");
        }
        menu();
    }

    public void depositMoney() {
        System.out.println("Enter the Amount: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        Balance = Balance + amount;
        System.out.println("Money Deposited Sucessfully");
        menu();
    }

    public void changePin() {
        System.out.println("Enter your new 4-digit PIN: ");
        Scanner sc = new Scanner(System.in);
        int newPin = sc.nextInt();

        // Validate the new pin (e.g., must be a 4-digit number)
        if (isValidPin(newPin)) {
            PIN = newPin;
            System.out.println("PIN successfully changed.");
        } else {
            System.out.println("Error: Invalid PIN. Please enter a 4-digit number.");
        }

        menu();
    }

    private boolean isValidPin(int pinToValidate) {
        return String.valueOf(pinToValidate).length() == 4;

    }
}
public class Accounts {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkPin();

    }
}

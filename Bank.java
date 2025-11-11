import java.util.Scanner;

class Account {
    protected String customerName;
    protected int accountNumber;
    protected String accountType;
    protected double balance;

    public Account(String customerName, int accountNumber, String accountType, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void displayBalance() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Current Balance: " + balance);
    }
}

class SavAcct extends Account {
    private static final double INTEREST_RATE = 0.05;

    public SavAcct(String customerName, int accountNumber, double balance) {
        super(customerName, accountNumber, "Savings", balance);
    }

    public void computeAndDepositInterest(int years) {
        double interest = balance * (Math.pow(1 + INTEREST_RATE, years) - 1);
        balance += interest;
        System.out.println("Compound interest of " + String.format("%.2f", interest) +
                           " added for " + years + " year(s).");
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
}

class CurAcct extends Account {
    private static final double MIN_BALANCE = 1000.0;
    private static final double SERVICE_CHARGE = 100.0;

    public CurAcct(String customerName, int accountNumber, double balance) {
        super(customerName, accountNumber, "Current", balance);
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Balance below minimum! Service charge of " + SERVICE_CHARGE + " imposed.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter account type (1 for Savings, 2 for Current): ");
        int type = sc.nextInt();

        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();

        Account account;
        if (type == 1)
            account = new SavAcct(name, accNo, initialBalance);
        else
            account = new CurAcct(name, accNo, initialBalance);

        int choice;
        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof SavAcct)
                System.out.println("4. Compute Interest");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    if (account instanceof SavAcct)
                        ((SavAcct) account).withdraw(wd);
                    else
                        ((CurAcct) account).withdraw(wd);
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    if (account instanceof SavAcct) {
                        System.out.print("Enter number of years: ");
                        int yrs = sc.nextInt();
                        ((SavAcct) account).computeAndDepositInterest(yrs);
                    } else {
                        System.out.println("Interest not applicable for Current Account!");
                    }
                    break;

                case 0:
                    System.out.println("Thank you for using our banking system!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
 
    


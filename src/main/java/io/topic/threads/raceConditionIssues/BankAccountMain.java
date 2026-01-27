class BankAccount {
    private long balance;

    public BankAccount(long initialAmount) {
        this.balance = initialAmount;
    }

    public void withdraw(long amount) {
        System.out.println("Withdrawing :" + amount);
        long newBalance = balance - amount;
        System.out.println("New Balance :" + newBalance);
        this.balance = newBalance;
    }

    public void deposit(long amount) {
        System.out.println("Depositing :" + amount);
        long newBalance = balance + amount;
        System.out.println("New Balance :" + newBalance);
        this.balance = newBalance;

    }

    public long getBalance() {
        return balance;
    }

}

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);
        Thread depositingThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bankAccount.deposit(100);
            }
        });

        Thread withdrawingThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bankAccount.withdraw(100);
            }
        });

        depositingThread.start();
        withdrawingThread.start();

        try {
            depositingThread.join();
            withdrawingThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Current Balance after 100 Times withdraw and deposit :" + bankAccount.getBalance());
    }

}

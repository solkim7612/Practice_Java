package homework;

class BalanceInsufficientException extends Exception {
    public BalanceInsufficientException(String message) {
        super(message);
    }
}

public class BankAccount {
    private int balance;

    BankAccount(int balance) {
        if (balance < 0) {
            System.out.println("마이너스 불가");
            return;
        }
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("0원 이하의 금액은 입금할 수 없습니다.");
        this.balance += amount;
        System.out.println(amount + "원 입금되었습니다.");
    }

    public void withdraw(int amount) throws BalanceInsufficientException {
        if (amount <= 0) throw new IllegalArgumentException("0원 이하의 금액은 출금할 수 없습니다.");
        if (amount > balance) throw new BalanceInsufficientException("잔액이 부족합니다. (현재 잔액: "+balance+")");
        this.balance += amount;
        System.out.println(amount + "원 출금되었습니다.");
    }
}


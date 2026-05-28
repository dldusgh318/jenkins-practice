package bank;

public class BankAccount {

    private String owner;
    private int balance;

    public BankAccount(String owner, int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("초기 잔액은 0 이상이어야 합니다.");
        }
        this.owner = owner;
        this.balance = initialBalance;
    }

    // 입금
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("입금액은 0보다 커야 합니다.");
        }
        balance += amount;
    }

    // 출금
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("출금액은 0보다 커야 합니다.");
        }
        if (amount > balance) {
            throw new IllegalStateException("잔액이 부족합니다.");
        }
        balance -= amount;
    }

    // 잔액 조회
    public int getBalance() {
        return balance;
    }

    // 계좌 주인 조회
    public String getOwner() {
        return owner;
    }
}

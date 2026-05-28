package bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class BankAccountTest {

    static BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("홍길동", 10000);
    }

    // 초기 잔액 확인
    @Test
    @Order(1)
    void testInitialBalance() {
        assertEquals(10000, account.getBalance());
    }

    // 계좌 주인 확인
    @Test
    @Order(2)
    void testGetOwner() {
        assertEquals("홍길동", account.getOwner());
    }

    // 입금
    @Test
    @Order(3)
    void testDeposit() {
        account.deposit(5000);
        assertEquals(15000, account.getBalance());
    }

    // 출금
    @Test
    @Order(4)
    void testWithdraw() {
        account.withdraw(3000);
        assertEquals(7000, account.getBalance());
    }

    // 잔액 부족 예외 처리
    @Test
    @Order(5)
    void testWithdrawInsufficientBalance() {
        assertThrows(IllegalStateException.class, () -> {
            account.withdraw(99999);
        });
    }

    // 0 이하 입금 예외 처리
    @Test
    @Order(6)
    void testDepositInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(0);
        });
    }

    // 음수 초기 잔액 예외 처리
    @Test
    @Order(7)
    void testNegativeInitialBalance() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("김철수", -1000);
        });
    }
}

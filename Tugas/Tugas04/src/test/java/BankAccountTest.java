
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @Test
    void saldoAwalNol() {
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    void depositMenambahSaldo() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    void depositNolTidakMengubahSaldo() {
        account.deposit(0.0);
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    void depositNegatifDitolak() {
        assertThrows(
            IllegalArgumentException.class,
            () -> account.deposit(-10.0)
        );
    }

    @Test
    void withdrawMengurangiSaldo() {
        account.deposit(100.0);
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), 0.001);
    }

    @Test
    void withdrawMelebihiSaldoDitolak() {
        account.deposit(50.0);
        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(60.0)
        );
        assertEquals(50.0, account.getBalance(), 0.001);
    }

    @Test
    void withdrawNegatifDitolak() {
        account.deposit(50.0);
        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(-5.0)
        );
    }

    @Test
    void withdrawSeluruhSaldoMenjadiNol() {
        account.deposit(50.0);
        account.withdraw(50.0);
        assertEquals(0.0, account.getBalance(), 0.001);
    }
}

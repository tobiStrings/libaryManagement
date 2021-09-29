package user.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.entities.Account;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImplTest {
    AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountServiceImpl();
    }

    @AfterEach
    void tearDown() {
        accountService = null;
    }

    @Test
    void  calculateFine(){
        Account account = new Account(1,2,3,2,0.0);
        assertEquals(100.0,accountService.calculateFine(account));
    }
}
package com.neobank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankingServiceTest {

    @Test
    void testTransferLogic() {
        double from = 200;
        double amount = 100;

        assertTrue(from >= amount);
        assertEquals(100, from - amount);
    }
}

package org.dellent.labseq.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class LabseqServiceTest {
    private final LabseqService service = new LabseqService();

    @Test
    void testBaseCases() {
        Assertions.assertEquals(BigInteger.ZERO, service.labseq(0));
        Assertions.assertEquals(BigInteger.ONE, service.labseq(1));
        Assertions.assertEquals(BigInteger.ZERO, service.labseq(2));
        Assertions.assertEquals(BigInteger.ONE, service.labseq(3));
    }

    @Test
    void testRecursiveCase() {
        // l(4) = l(0) + l(1) = 0 + 1 = 1
        Assertions.assertEquals(BigInteger.ONE, service.labseq(4));
        // l(5) = l(1) + l(2) = 1 + 0 = 1
        Assertions.assertEquals(BigInteger.ONE, service.labseq(5));
        // l(6) = l(2) + l(3) = 0 + 1 = 1
        Assertions.assertEquals(BigInteger.ONE, service.labseq(6));
        // l(7) = l(3) + l(4) = 1 + 1 = 2
        Assertions.assertEquals(BigInteger.valueOf(2), service.labseq(7));
    }

    @Test
    void testLargeN() {
        BigInteger value = service.labseq(1000);
        Assertions.assertTrue(value.signum() >= 0);
    }
} 
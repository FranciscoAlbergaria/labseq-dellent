package org.dellent.labseq.service;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.cache.CacheResult;
import java.math.BigInteger;

@ApplicationScoped
public class LabseqService {
    @CacheResult(cacheName = "labseq-cache")
    public BigInteger labseq(int n) {
        if (n < 0) throw new IllegalArgumentException("Index must be non-negative");
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        if (n == 2) return BigInteger.ZERO;
        if (n == 3) return BigInteger.ONE;
        if (n < 4) return labseq(n);
        BigInteger[] seq = new BigInteger[n + 1];
        seq[0] = BigInteger.ZERO;
        seq[1] = BigInteger.ONE;
        seq[2] = BigInteger.ZERO;
        seq[3] = BigInteger.ONE;
        for (int i = 4; i <= n; i++) {
            seq[i] = seq[i - 4].add(seq[i - 3]);
        }
        return seq[n];
    }
}
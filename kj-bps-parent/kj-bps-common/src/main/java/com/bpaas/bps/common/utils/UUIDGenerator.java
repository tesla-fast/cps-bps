package com.bpaas.bps.common.utils;

import java.security.SecureRandom;

public class UUIDGenerator {
	private static final SecureRandom numberGenerator;
    
    public static String randomUUID() {
        final byte[] randomBytes = new byte[16];
        UUIDGenerator.numberGenerator.nextBytes(randomBytes);
        final byte[] array = randomBytes;
        final int n = 6;
        array[n] &= 0xF;
        final byte[] array2 = randomBytes;
        final int n2 = 6;
        array2[n2] |= 0x40;
        final byte[] array3 = randomBytes;
        final int n3 = 8;
        array3[n3] &= 0x3F;
        final byte[] array4 = randomBytes;
        final int n4 = 8;
        array4[n4] |= (byte)128;
        long msb = 0L;
        long lsb = 0L;
        assert randomBytes.length == 16 : "data must be 16 bytes in length";
        for (int i = 0; i < 8; ++i) {
            msb = (msb << 8 | (long)(randomBytes[i] & 0xFF));
        }
        for (int i = 8; i < 16; ++i) {
            lsb = (lsb << 8 | (long)(randomBytes[i] & 0xFF));
        }
        return toString(msb, lsb);
    }
    
    private static String toString(final long mostSigBits, final long leastSigBits) {
        return digits(mostSigBits >> 32, 8) + digits(mostSigBits >> 16, 4) + digits(mostSigBits, 4) + digits(leastSigBits >> 48, 4) + digits(leastSigBits, 12);
    }
    
    private static String digits(final long val, final int digits) {
        final long hi = 1L << digits * 4;
        return Long.toHexString(hi | (val & hi - 1L)).substring(1);
    }
    
    public static void main(final String[] args) {
    }
    
    static {
        numberGenerator = new SecureRandom();
    }
}

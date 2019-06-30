package net.cloudburo.polkadot.types.codec;

public class UIntBitLength {

    public static final int DEFAULT_UINT_BITS = 64;

    public static UINT_BIT_LENGTH setFromInt(int value) {

        switch (value) {
            case 8:  return UINT_BIT_LENGTH.L8;
            case 16: return UINT_BIT_LENGTH.L16;
            case 32: return UINT_BIT_LENGTH.L32;
            case 64: return UINT_BIT_LENGTH.L64;
            case 128: return UINT_BIT_LENGTH.L128;
            case 256: return UINT_BIT_LENGTH.L256;
        }
        if (value <8) return UINT_BIT_LENGTH.L8;
        if (value >8 && value <16) return UINT_BIT_LENGTH.L16;
        if (value >16 && value <32) return UINT_BIT_LENGTH.L32;
        if (value >32 && value <64) return UINT_BIT_LENGTH.L64;
        if (value >64 && value <128) return UINT_BIT_LENGTH.L128;
        return UINT_BIT_LENGTH.L256;
    }

    public enum UINT_BIT_LENGTH{
        L8(8),
        L16(16),
        L32(32),
        L64(64),
        L128(128),
        L256(256);

        private final int value;

        UINT_BIT_LENGTH(final int newValue) {
            value = newValue;
        }
        public int getBitLength() { return value; }
    }

    public int bitLength;
    public int inBytes;

    public UIntBitLength(UINT_BIT_LENGTH bitLength){
        this.bitLength = bitLength.getBitLength();
        this.inBytes = bitLength.getBitLength()/8;
    }
}

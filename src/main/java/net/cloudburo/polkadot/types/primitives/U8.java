package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.common.SubstrateTypeException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.codec.UInt;
import net.cloudburo.polkadot.types.codec.UIntBitLength;

import java.math.BigInteger;

/**
 * A 8 bit unsigned integer
 */
public class U8 extends UInt {

    public U8(BigInteger bn) throws SubstrateTypeException {
        super(bn,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L8));
    }

    public U8(int bn) throws SubstrateTypeException {
        super(BigInteger.valueOf(bn),new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L8));
    }

    public U8(ScaleBytes data ) throws SubstrateTypeException {
        super(data,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L8));
    }

    public U8(ScaleBytes data, String subType ) throws SubstrateTypeException {
        super(data,subType,new UIntBitLength(UIntBitLength.UINT_BIT_LENGTH.L8));
    }


}

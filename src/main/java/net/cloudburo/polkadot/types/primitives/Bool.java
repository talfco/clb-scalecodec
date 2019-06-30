package net.cloudburo.polkadot.types.primitives;

import net.cloudburo.polkadot.types.common.InvalidScaleTypeValueException;
import net.cloudburo.polkadot.types.common.ScaleBytes;
import net.cloudburo.polkadot.types.common.ScaleType;

/**
 * Representation for a boolean value in the system
 */
public class Bool extends ScaleType {

    public Bool(ScaleBytes data ) {
        super(data, null);
    }

    public  Object  process() throws InvalidScaleTypeValueException {
        return Boolean.valueOf(this.getNextBool());
    }
}

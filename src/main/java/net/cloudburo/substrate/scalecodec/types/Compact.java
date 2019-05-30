package net.cloudburo.substrate.scalecodec.types;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import net.cloudburo.substrate.scalecodec.base.ScaleBytes;
import net.cloudburo.substrate.scalecodec.base.ScaleType;

public class Compact extends ScaleType{

    private int compactLength;
    private byte[] compactBytes;

    public Compact(ScaleBytes data, String subType) {
        super(data,subType,null);
        // TODO metaData
    }

    public byte[] processCompactBytes() throws java.io.IOException {
        byte[] compactByte = this.getNextBytes(1);
        int byteMod = compactByte[0] % 4;
        if (byteMod == 0) {
            this.compactLength = 1;
            this.compactBytes = compactByte;
        }
        else if (byteMod ==1) {
            this.compactLength = 2;
            ByteArrayOutputStream myStream = new ByteArrayOutputStream();
            myStream.write(compactByte);
            myStream.write(this.getNextBytes(this.compactLength-1));
            this.compactBytes = myStream.toByteArray();
        }
        else if (byteMod == 2 ) {
            this.compactLength = 4;
            ByteArrayOutputStream myStream = new ByteArrayOutputStream();
            myStream.write(compactByte);
            myStream.write(this.getNextBytes(this.compactLength-1));
            this.compactBytes = myStream.toByteArray();
        }
        else {
            this.compactLength = 5 + (compactByte[0] - 3) / 4;
            this.compactBytes = this.getNextBytes(this.compactLength-1);
        }
        return this.compactBytes;
    }

    public Object process() throws IOException {
        this.processCompactBytes();
        // TODO
        return null;
    }


}

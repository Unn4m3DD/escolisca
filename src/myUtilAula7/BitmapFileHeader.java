package myUtilAula7;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class BitmapFileHeader {
    private short type;       // must be 'BM' to declare a bmp-file
    private int size;         // specifies the size of the file in bytes
    private short reserved1;  // must always be set to zero
    private short reserved2;  // must always be set to zero
    private int offBits;      // specifies the offset from the
    // beginning of the file to the bitmap data

    public BitmapFileHeader(short type, int size, short reserved1, short reserved2, int offBits) {
        this.type = type;
        this.size = size;
        this.reserved1 = reserved1;
        this.reserved2 = reserved2;
        this.offBits = offBits;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public byte[] toBytes() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
        outputStream.write(ByteUtil.toBytes(type));
        outputStream.write(ByteUtil.toBytes(size));
        outputStream.write(ByteUtil.toBytes(reserved1));
        outputStream.write(ByteUtil.toBytes(reserved2));
        outputStream.write(ByteUtil.toBytes(offBits));
        return outputStream.toByteArray();
    }
    public short getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public short getReserved1() {
        return reserved1;
    }

    public short getReserved2() {
        return reserved2;
    }

    public int getOffBits() {
        return offBits;
    }

    public int getOffBytes() {
        return offBits/8;
    }
}

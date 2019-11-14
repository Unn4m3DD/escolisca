package myUtilAula7;

import java.io.*;
import java.util.*;

public class Bitmap {
    private BitmapFileHeader bitmapFileHeader;
    private BitmapInfoHeader bitmapInfoHeader;
    private byte[] rgbQuad;  // color pallete – opcional (ver abaixo)
    private byte[] data;     // pixel data

    public Bitmap(BitmapFileHeader bitmapFileHeader, BitmapInfoHeader bitmapInfoHeader, byte[] rgbQuad, byte[] data) {
        this.bitmapFileHeader = bitmapFileHeader;
        this.bitmapInfoHeader = bitmapInfoHeader;
        this.rgbQuad = rgbQuad;
        this.data = data;
    }

    public static Bitmap bpmFromFile(String fName) throws IOException {
        BitmapFileHeader bitmapFileHeader;
        BitmapInfoHeader bitmapInfoHeader;
        RandomAccessFile raf = new RandomAccessFile(fName, "r");
        bitmapFileHeader = new BitmapFileHeader(
                Short.reverseBytes(raf.readShort()),
                Integer.reverseBytes(raf.readInt()),
                Short.reverseBytes(raf.readShort()),
                Short.reverseBytes(raf.readShort()),
                Integer.reverseBytes(raf.readInt())
        );
        bitmapInfoHeader = new BitmapInfoHeader(
                Integer.reverseBytes(raf.readInt()),
                Integer.reverseBytes(raf.readInt()),
                Integer.reverseBytes(raf.readInt()),
                Short.reverseBytes(raf.readShort()),
                Short.reverseBytes(raf.readShort()),
                Integer.reverseBytes(raf.readInt()),
                Integer.reverseBytes(raf.readInt()),
                Integer.reverseBytes(raf.readInt()),
                Integer.reverseBytes(raf.readInt()),
                Integer.reverseBytes(raf.readInt()),
                Integer.reverseBytes(raf.readInt())
        );

        raf.seek(bitmapFileHeader.getOffBits());
        int pixelDataLength = Math.abs(bitmapInfoHeader.getBitCount() / 8 * bitmapInfoHeader.getHeight() * bitmapInfoHeader.getWidth());
        byte[] pixelsData = new byte[pixelDataLength];
        raf.read(pixelsData, 0, pixelDataLength);
        if (bitmapInfoHeader.getHeight() < 0)
            Collections.reverse(Arrays.asList(pixelsData));
        return new Bitmap(bitmapFileHeader, bitmapInfoHeader, new byte[0], pixelsData);

    }

    public void toFile(String fname) throws IOException {
        try (RandomAccessFile bmp = new RandomAccessFile(fname, "rw");) {
            bmp.write(getBitmapFileHeader().toBytes());
            bmp.write(getBitmapInfoHeader().toBytes());
            bmp.write(getData());
        }
    }

    public void toRaw(String fname) throws IOException {
        try (RandomAccessFile raw = new RandomAccessFile(fname, "rw");) {
            raw.write((getData()));
        }
    }


    public BitmapFileHeader getBitmapFileHeader() {
        return bitmapFileHeader;
    }

    public BitmapInfoHeader getBitmapInfoHeader() {
        return bitmapInfoHeader;
    }

    public byte[] getRgbQuad() {
        return rgbQuad;
    }

    public byte[] getData() {
        return data;
    }

    void setArrayIndexed(byte[] b, int i, int j, int linelen, byte val) {
        b[i * linelen] = val;
    }

    byte getArrayIndexed(byte[] b, int i, int j, int linelen) {
        return b[i * linelen];
    }

    public void reduceImage() {
        byte[] newData = new byte[data.length / 4];
        var newWidth = bitmapInfoHeader.getWidth() / 2;
        var newHeight = Math.abs(bitmapInfoHeader.getHeight()) / 2;
        for (int j = 0; j < newHeight * 3; j += 3)
            for (int i = 0; i < newWidth * 3; i += 3) {
                int addr1 = j * newWidth + i;
                int addr2 = 2 * (j * bitmapInfoHeader.getWidth() + i);
                newData[addr1] =
                        data[addr2];
                newData[addr1 + 1] = data[addr2 + 1];
                newData[addr1 + 2] = data[addr2 + 2];
            }
        data = newData;


        bitmapInfoHeader.setHeight(bitmapInfoHeader.getHeight() / 2);
        bitmapInfoHeader.setWidth(bitmapInfoHeader.getWidth() / 2);
        bitmapFileHeader.setSize(
                bitmapFileHeader.getSize() - Math.abs(bitmapInfoHeader.getHeight()) * bitmapInfoHeader.getWidth() * bitmapInfoHeader.getBitCount() / 8
        );
    }

    public void flipHorizontal() {
        byte[] newData = new byte[data.length];
        var width = bitmapInfoHeader.getWidth() ;
        var heigth = Math.abs(bitmapInfoHeader.getHeight()) ;
        for (int j = 0; j < heigth ; j ++)
            for (int i = 0; i < width * 3  ; i += 3) {
                int addr1 = j * width * 3 + i;
                int addr2 = j * width * 3 + width * 3 - i - 3;
                newData[addr1] =
                        data[addr2];
                newData[addr1 + 1] = data[addr2 + 1];
                newData[addr1 + 2] = data[addr2 + 2];
            }
        data = newData;
    }

    public void flipVertical() {
        byte[] newData = new byte[data.length];
        var width = bitmapInfoHeader.getWidth() ;
        var heigth = Math.abs(bitmapInfoHeader.getHeight()) ;
        for (int j = 0; j < heigth ; j ++)
            for (int i = 0; i < width * 3  ; i += 3) {
                int addr1 = j * width * 3 + i;
                int addr2 = (heigth - j - 1) * width * 3 + i;
                newData[addr1] =
                        data[addr2];
                newData[addr1 + 1] = data[addr2 + 1];
                newData[addr1 + 2] = data[addr2 + 2];
            }
        data = newData;
    }
}

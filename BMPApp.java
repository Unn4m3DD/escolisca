package aula7;

import java.io.*;
import java.util.*;


public class BMPApp {
	public static void main(String[] args) {
		String filename = "Figura.bmp";
		try (RandomAccessFile raf = new RandomAccessFile(filename, "rw");){
			raf.seek(0);
			BitmapFileHeader bmfh = new BitmapFileHeader(
					Short.reverseBytes(raf.readShort()),
					Integer.reverse(raf.readInt()),
					Short.reverseBytes(raf.readShort()),
					Short.reverseBytes(raf.readShort()),
					Integer.reverse(raf.readInt())
			);

			BitmapInfoHeader bmih = new BitmapInfoHeader(
					Integer.reverse(raf.readInt()),
					Integer.reverse(raf.readInt()),
					Integer.reverse(raf.readInt()),
					Short.reverseBytes(raf.readShort()),
					Short.reverseBytes(raf.readShort()),
					Integer.reverse(raf.readInt()),
					Integer.reverse(raf.readInt()),
					Integer.reverse(raf.readInt()),
					Integer.reverse(raf.readInt()),
					Integer.reverse(raf.readInt()),
					Integer.reverse(raf.readInt())
					);
			
			if(bmih.clrUsed != 0)
				System.out.println("Cuidado existe palete!");
			raf.seek(bmfh.offBits);
			System.out.println("Width: " + bmih.width + "\tHeight: " + bmih.height);
			int dataLength = (bmih.bitCount / 8) * bmih.width * bmih.height;
			byte[] rawData = new byte[dataLength];
			raf.read(rawData, 0, dataLength);
			System.out.println(dataLength);
			Bitmap bmp = new Bitmap(bmfh, bmih, rawData);
			RandomAccessFile rawDataFile = new RandomAccessFile("Figura.raw", "rw");
			rawDataFile.write(bmp.data);
			rawDataFile.close();
			raf.close();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Fuck");
		}
	}
}

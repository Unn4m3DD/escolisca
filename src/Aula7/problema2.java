package Aula7;

import myUtilAula7.Bitmap;

import java.io.IOException;
import java.util.Arrays;

public class problema2 {
    public static void main(String[] args) throws IOException {
        Bitmap b = Bitmap.bpmFromFile("Figura.bmp");
        System.out.println("Offset para Pixel Data: " + b.getBitmapFileHeader().getOffBytes());
        System.out.println("Tamanho da File é: " + b.getBitmapFileHeader().getSize());
        System.out.println("Color depth: " + b.getBitmapInfoHeader().getBitCount());
        System.out.println("Size of bmp info header: " + b.getBitmapInfoHeader().getSize());
        System.out.println("Numero Cores usadas: " + b.getBitmapInfoHeader().getClrUsed());
        System.out.println("Height: " + b.getBitmapInfoHeader().getHeight());
        System.out.println("Width:  " + b.getBitmapInfoHeader().getWidth());
        System.out.println(b.getData().length);
        b.toRaw("sena.raw");
        b.reduceImage();
        b.flipHorizontal();
        b.flipVertical();
        b.reduceImage();
        b.toFile("sena.bmp");
    }
}

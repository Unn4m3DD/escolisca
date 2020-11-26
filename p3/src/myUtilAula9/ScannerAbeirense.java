package myUtilAula9;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class ScannerAbeirense implements Iterator<String>, Closeable, Iterable<String>  {
    Scanner fs;

    public ScannerAbeirense(File f) throws IOException {
        this.fs = new Scanner(f);
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public boolean hasNext() {
        return fs.hasNextLine();
    }

    @Override
    public String next() {
        String result = "";
        for (var c : fs.next().toCharArray()) {
            if (c == 'v')
                result += 'b';
            else if (c == 'V')
                result += 'B';
            else if (c == 'b')
                result += 'v';
            else if (c == 'B')
                result += 'V';
            else
                result += c;
        }
        return result;
    }

    @Override
    public Iterator<String> iterator() {
        return this;
    }
}

package myUtilAula5;

import java.io.FileWriter;
import java.util.Scanner;

public interface Parser {
    ListaPessoas parseScanner(Scanner k);

    void writeFw(ListaPessoas lp, FileWriter fw);
}

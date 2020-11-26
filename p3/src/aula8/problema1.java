package aula8;

import myUtilAula8.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class problema1 {
    static myJButton[][] btns = new myJButton[3][3];
    static TicTacToe t = new TicTacToe();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo do Galo");
        var gl = new GridLayout(3, 3);
        frame.setLayout(gl);
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                btns[i][j] = new myJButton();
                btns[i][j].i = i;
                btns[i][j].j = j;
                btns[i][j].addActionListener((e) -> {
                    myJButton b = (myJButton) e.getSource();
                    clicked(b.i, b.j, b);
                });
                btns[i][j].setSize(100, 100);
                frame.add("b" + i + j, btns[i][j]);
            }

        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    static void clicked(int i, int j, myJButton b) {
        b.setText(t.click(i, j));
        if (!t.testWin().equals("")) {
            System.out.println(t.testWin() + " ganhou");
            System.exit(0);
        }
    }
}

class myJButton extends JButton {
    int i, j;
}
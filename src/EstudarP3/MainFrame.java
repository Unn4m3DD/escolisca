package EstudarP3;

import myUtilAula10.Mutable;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;

public class MainFrame extends JFrame implements ActionListener {
    JPanel[] panels = new JPanel[9];
    newJButton[] buttons = new newJButton[9];

    public MainFrame(String name) {
        super(name);
        setSize(new Dimension(500, 200));
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
            buttons[i] = new newJButton();
            buttons[i].i = i;
            buttons[i].setPreferredSize(new Dimension(100, 50));
            panels[i].add(buttons[i]);
            add(panels[i]);
            buttons[i].addActionListener(this);

        }
    }

    public static void main(String[] args) {
        (new MainFrame("asd")).setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "" + ((newJButton) e.getSource()).i);
    }

    class newJButton extends JButton {
        int i;
    }
}
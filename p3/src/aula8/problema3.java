package aula8;

import myUtilAula8.Question;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class problema3 extends JFrame {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    Question[] qs = Question.parseFile("quiz.txt");
    int c_question = 0;
    int[] awnsers = new int[qs.length];

    JLabel image, pergunta, recompensa;
    JButton ajudaDoPublico, telefone, cinqcinq, desistir, confirmar;
    MyJRadioButton[] r = new MyJRadioButton[4];
    ButtonGroup bGroup;
    int[] prize = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 100};

    void updateQuestion() throws IOException {
        image.setIcon(new ImageIcon(ImageIO.read(new File(qs[c_question].getimgPath()))));
        image.repaint();
        pergunta.setText(qs[c_question].getPergunta());
        recompensa.setText("" + prize[qs[c_question].getDifficulty()] + "$");
        for (int i = 0; i < 4; i++){
            r[i].setEnabled(true);
            r[i].setText(qs[c_question].getAArray()[i]);
        }
        bGroup.clearSelection();
    }

    private problema3() {
        super("Imagemzitas e tal");
    }

    public void start() throws IOException {
        parseQuestions();
        setSize(750, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);

        setUpperLayout();
        setHelpBtns();
        setBottomBtns();
        updateQuestion();
        setVisible(true);

    }

    private void parseQuestions() {
    }

    private void setBottomBtns() {
        var p = new JPanel();
        p.setLayout(new BorderLayout(0, 0));
         bGroup = new ButtonGroup();
        var p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 2));
        for (int i = 0; i < 4; i++) {
            r[i] = new MyJRadioButton();
            r[i].setText("" + i);
//            r[i].setPreferredSize(new Dimension(100,100));
            r[i].id = i;
            p1.add(r[i]);
            bGroup.add(r[i]);
        }
        p.setBackground(new Color(10, 10, 10, 10));
        p.add(p1, BorderLayout.CENTER);


        var p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 2));
        desistir = new JButton();
        desistir.setText("Desistir");
        desistir.setPreferredSize(new Dimension(100, 50));
        p2.add(desistir);
        confirmar = new JButton();
        confirmar.setText("Confirmar");
        confirmar.setPreferredSize(new Dimension(100, 50));
        p2.add(confirmar);
        p.add(p2, BorderLayout.EAST);
        add(p, BorderLayout.SOUTH);

        desistir.addActionListener((e) -> {
            System.exit(0);
        });
        confirmar.addActionListener((e) -> {
            if(r[qs[c_question].getCorrectAwnser()].isSelected())
                JOptionPane.showMessageDialog(null, "Certo");
            else
                JOptionPane.showMessageDialog(null, "Errado");
            c_question++;
            if (c_question == qs.length) System.exit(0);
            try {
                updateQuestion();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
    }

    private void setHelpBtns() {
        var p = new JPanel();
        p.setLayout(new GridLayout(1, 3));
        ajudaDoPublico = new JButton();
        ajudaDoPublico.setText("Ajuda Publico");
        ajudaDoPublico.setPreferredSize(new Dimension(200, 50));
        var p1 = new JPanel();
        p1.add(ajudaDoPublico);
        p.add(p1);
        telefone = new JButton();
        telefone.setText("Telefone");
        telefone.setPreferredSize(new Dimension(200, 50));
        var p2 = new JPanel();
        p2.add(telefone);
        p.add(p2);
        cinqcinq = new JButton();
        cinqcinq.setText("50-50");
        p.add(cinqcinq);
        var p3 = new JPanel();
        cinqcinq.setPreferredSize(new Dimension(200, 50));
        p3.add(cinqcinq);
        p.add(p3);
        add(p, BorderLayout.CENTER);

        ajudaDoPublico.addActionListener((e) -> {
            JOptionPane.showMessageDialog(null, "Utilizou a ajuda do publico");
            ajudaDoPublico.setEnabled(false);
        });
        telefone.addActionListener((e) -> {
            JOptionPane.showMessageDialog(null, "Utilizou a ajuda do telefone");
            telefone.setEnabled(false);
        });

        cinqcinq.addActionListener((e) -> {
            JOptionPane.showMessageDialog(null, "Utilizou a ajuda do 50-50");
            int count = 0;
            int first_idx = -1;
            while (count < 2) {
                int r_idx = (int) Math.floor(Math.random() * 4);
                if (r_idx != qs[c_question].getCorrectAwnser() && r_idx != first_idx) {
                    r[r_idx].setEnabled(false);
                    first_idx = r_idx;
                    count++;
                }
            }
            cinqcinq.setEnabled(false);
        });
    }

    private void setUpperLayout() throws IOException {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));

        image = new JLabel(new ImageIcon(ImageIO.read(new File("Figura.bmp"))));
        p.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 1));
        JPanel recompensaPanel = new JPanel();
        recompensaPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.NORTHEAST;
        gc.insets = new Insets(0, 0, 0, 5);
        recompensa = new JLabel("Recompensa");
        recompensaPanel.add(recompensa, gc);
        p2.add(recompensaPanel);
        pergunta = new JLabel("Pergunta");
        pergunta.setFont(new Font("", Font.BOLD, 32));
        p2.add(pergunta);
        p.add(p2);
        add(p, BorderLayout.NORTH);
    }

    public static void main(String[] args) throws IOException {
        new problema3().start();
    }

    class MyJRadioButton extends JRadioButton {
        int id;
    }
}

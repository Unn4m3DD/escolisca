package aula8;

import myUtilAula7.Bitmap;
import myUtilAula8.PanelImage;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class problema2 {
    static Toolkit toolkit = Toolkit.getDefaultToolkit();
    static Dimension screenSize = toolkit.getScreenSize();
    static Bitmap bmp;
    static String c_fname;

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Imagemzitas e tal");
        JPanel panel = new PanelImage(new byte[3], 1, 1);

        if (args.length == 1) {
            c_fname = args[0];
            setImage(c_fname, panel, frame);
        } else {
            frame.setSize(750, 150);
        }
        frame.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.add(panel, BorderLayout.CENTER);
        frame.add(p);
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(1, 3));

        var b1 = new JButton();
        b1.setPreferredSize(new Dimension(b1.getWidth(), 100));
        b1.setText("Select File");
        menu.add(b1);

        var b2 = new JButton();
        b2.setPreferredSize(new Dimension(b2.getWidth(), 100));
        b2.setText("Flip Vertical");
        menu.add(b2);

        var b3 = new JButton();
        b3.setPreferredSize(new Dimension(b3.getWidth(), 100));
        b3.setText("Flip Horizontal");
        menu.add(b3);

        var b4 = new JButton();
        b4.setPreferredSize(new Dimension(b4.getWidth(), 100));
        b4.setText("Size / 4");
        menu.add(b4);

        var b5 = new JButton();
        b5.setPreferredSize(new Dimension(b5.getWidth(), 100));
        b5.setText("Save As");
        menu.add(b5);
        var b6 = new JButton();
        b6.setPreferredSize(new Dimension(b6.getWidth(), 100));
        b6.setText("Save");
        menu.add(b6);

        frame.add(menu, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;

        frame.setLocation(x, y);


        b1.addActionListener((e) -> {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Bitmap Images (.bmp)", "bmp");
            jfc.setFileFilter(filter);
            int returnValue = jfc.showOpenDialog(null);
            // int returnValue = jfc.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                try {
                    c_fname = jfc.getSelectedFile().getAbsolutePath();
                    setImage(jfc.getSelectedFile().getAbsolutePath(), panel, frame);
                } catch (Exception ex) {
                }
            }
            panel.repaint();
        });
        b2.addActionListener((e) -> {
            try {
                flipVerticalImage(panel);
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
            panel.repaint();
        });
        b3.addActionListener((e) -> {
            try {
                flipHorizontalImage(panel);
            } catch (Exception ex) {
            }
            panel.repaint();
        });
        b4.addActionListener((e) -> {
            try {
                redim(panel, frame);
            } catch (Exception ex) {
            }
            panel.repaint();
        });
        b5.addActionListener((e) -> {
            try {
                String name = JOptionPane.showInputDialog(null, "Nome da file", null);
                bmp.toFile(name);
            } catch (Exception ex) {
            }
            panel.repaint();
        });
        b6.addActionListener((e) -> {
            try {
                bmp.toFile(c_fname);
            } catch (Exception ex) {
            }
            panel.repaint();
        });
    }

    private static void redim(JPanel panel, JFrame frame) {
        bmp.reduceImage();
        ((PanelImage) panel).updateImage(
                bmp.getData(),
                bmp.getBitmapInfoHeader().getWidth(),
                Math.abs(bmp.getBitmapInfoHeader().getHeight())
        );
        frame.setSize(750, Math.abs(bmp.getBitmapInfoHeader().getHeight()) + 150);
    }

    private static void flipVerticalImage(JPanel panel) {
        bmp.flipVertical();
        ((PanelImage) panel).updateImage(
                bmp.getData(),
                bmp.getBitmapInfoHeader().getWidth(),
                Math.abs(bmp.getBitmapInfoHeader().getHeight())
        );
    }

    private static void flipHorizontalImage(JPanel panel) {
        bmp.flipHorizontal();
        ((PanelImage) panel).updateImage(
                bmp.getData(),
                bmp.getBitmapInfoHeader().getWidth(),
                Math.abs(bmp.getBitmapInfoHeader().getHeight())
        );
    }

    private static void setImage(String fName, JPanel panel, JFrame frame) throws IOException {
        bmp = Bitmap.bpmFromFile(fName); //parser developed in “guião 7”
        ((PanelImage) panel).updateImage(
                bmp.getData(),
                bmp.getBitmapInfoHeader().getWidth(),
                Math.abs(bmp.getBitmapInfoHeader().getHeight())
        );
        frame.setSize(750, Math.abs(bmp.getBitmapInfoHeader().getHeight()) + 150);
    }
}

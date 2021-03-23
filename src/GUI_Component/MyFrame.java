package GUI_Component;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MyFrame extends JFrame{ // configura uno standard per il frame

    public MyFrame(String title) { // crea uno standard per i frame
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(43, 43, 43));
        this.setLayout(new GridLayout(1, 2, 10, 0));
    }
}

package GUI_Component;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MyLabel extends JLabel { // crea una label standard
    public MyLabel(String text) {
        this.setText(text);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setForeground(Color.white);
        this.setHorizontalTextPosition(JLabel.LEFT);
        this.setVerticalTextPosition(JLabel.CENTER);
    }
}

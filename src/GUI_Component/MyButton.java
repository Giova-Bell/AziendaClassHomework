package GUI_Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButton extends JButton implements ActionListener { // configura uno standard per il bottone
    ButtonFunction function;

    public MyButton(String text, ButtonFunction function) {
        this.function = function;
        this.addActionListener(this);
        this.setText(text);
        this.setFocusable(false);
        this.setSize(20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.function.function();
    }
}

package GUI_Component;

import java.awt.GridLayout;

import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Spazio extends MyPanel {
    public Spazio(MyButton button) {
        super(null);
        this.setLayout(new GridLayout(1, 1));
        this.setBorder(new EmptyBorder(10, 30, 10, 30));
        this.add(button);
    }
}

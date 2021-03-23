package GUI_Component;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class MyPanel extends JPanel { // crea un panel standard
    public MyPanel(String title) {
        this.setBackground(new Color(43, 43, 43));

        //border
        Border border = BorderFactory.createTitledBorder(title);
        this.setBorder(border);
        
        // border color
        TitledBorder titleBorder = (TitledBorder)this.getBorder();
        titleBorder.setTitleColor(Color.white);
    }
}

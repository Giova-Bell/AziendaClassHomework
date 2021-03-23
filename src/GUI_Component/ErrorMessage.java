package GUI_Component;

import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class ErrorMessage extends MyLabel { // crea una label standard per mostrare un errore
    public MyLabel myLabel;
    public ErrorMessage(String text) {
        super(text);
        this.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
        this.setForeground(Color.red);
    }
}

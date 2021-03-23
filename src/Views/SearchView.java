package Views;


import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Azienda_Class.Azienda;
import Azienda_Class.Operaio;
import GUI_Component.ButtonFunction;
import GUI_Component.ErrorMessage;
import GUI_Component.MyButton;
import GUI_Component.MyFrame;
import GUI_Component.MyPanel;
import GUI_Component.MyTable;

public class SearchView {
    private MyFrame myFrame;
    static private int nButton;

    public SearchView(Azienda azienda, int inNButton) {
        nButton = inNButton; // riconosce il bottone da cui è stata richiamata la funzione

        JTextField textField = new JTextField(); // inizializza l'input
        textField.setPreferredSize(new Dimension(150, 25));
        
        ButtonFunction function = () -> {}; //inizializza la funzione per il bottone cerca
        switch (nButton) {
            case 0:
                function = () -> {
                    try {
                        showView(azienda.cercaMatricole(Integer.parseInt(textField.getText())));
                        myFrame.setVisible(false);
                    } catch (Exception r) {
                        showView(new Operaio[] {});
                        myFrame.setVisible(false);
                    }
                };
            break;
            case 1:
                function = () -> {
                    showView(azienda.cercaReparto(textField.getText()));
                    myFrame.setVisible(false);
                };
            break;
        }
        MyButton button = new MyButton("Cerca", function);

        MyPanel panel = new MyPanel(null);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(textField);
        panel.add(button);


        myFrame = new MyFrame("Search");
        myFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        myFrame.add(panel);
        myFrame.pack();
    }

    static public void showView(Operaio[] operai) { // mostra in una tabella l'array di operai passato
        MyFrame myRisFrame = new MyFrame(null);
        myRisFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        if(operai.length != 0) { // controlla che nell'array sia presente almeno 1 elemento
            MyPanel panelTable = new MyPanel(null);
            panelTable.setBorder(null);
            panelTable.add(new JScrollPane(new MyTable(operai)));

            myRisFrame.add(panelTable);
        } else {
            ErrorMessage errorMessage = new ErrorMessage(null); // mostra una finestra di errore
            switch (nButton) {
                case 0:
                    errorMessage = new ErrorMessage("Matricola non trovata");
                break;
                case 1:
                    errorMessage = new ErrorMessage("Reparto non trovato");
                break;
            }
            myRisFrame.add(errorMessage);
        }
        myRisFrame.pack();
    }
}

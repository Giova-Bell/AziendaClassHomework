package Views;

import java.awt.GridLayout;

import javax.swing.JScrollPane;

import Azienda_Class.Azienda;
import GUI_Component.ButtonFunction;
import GUI_Component.MyButton;
import GUI_Component.MyFrame;
import GUI_Component.MyPanel;
import GUI_Component.MyTable;
import GUI_Component.Spazio;

public class MainView {
    //private MyFrame myFrame;

    public MainView(Azienda azienda) {
        ///////////////////
        // CREAZIONE GUI
        ///////////////////
        MyTable myTable = new MyTable(azienda.operai); // inizializzazione tabella


        // Panel 1
        //////////////
        MyPanel panelButton1 = new MyPanel("Cerca");
        panelButton1.setLayout(new GridLayout(3, 1));

        ButtonFunction buttonFunction = () -> { // dichiarazione di una funzione lambda per il bottone
            new SearchView(azienda, 0);
        };
        panelButton1.add(new Spazio(new MyButton("Cerca Matricola", buttonFunction)));

        buttonFunction = () -> {
            new SearchView(azienda, 1);
        };
        panelButton1.add(new Spazio(new MyButton("Cerca Operai In Reparto", buttonFunction)));

        buttonFunction = () -> {
            SearchView.showView(azienda.stampaDipendentiConMinorNumeroFigli());
        };
        panelButton1.add(new Spazio(new MyButton("Cerca Operai Con Minor Numero Di Figli", buttonFunction)));


        // Panel 2
        //////////////
        MyPanel panelButton2 = new MyPanel("Ordina");
        panelButton2.setLayout(new GridLayout(2, 1));
        buttonFunction = () -> {
            azienda.ordinaPerMatricola();
            myTable.refreshTable(azienda.operai);
        };

        panelButton2.add(new Spazio(new MyButton("Stampa Operai In Ordine Di Matricola", buttonFunction)));
        buttonFunction = () -> {
            azienda.ordinaPerFigli();
            myTable.refreshTable(azienda.operai);
        };
        panelButton2.add(new Spazio(new MyButton("Stampa Operai In Ordine Di Figli", buttonFunction)));

        
        // Panel 3
        //////////////
        MyPanel panelWrapper = new MyPanel(null);
        panelWrapper.setLayout(new GridLayout(2, 1));
        panelWrapper.add(panelButton1);
        panelWrapper.add(panelButton2);

        
        // Table Panel
        /////////////////
        MyPanel panelTable = new MyPanel(null);
        panelTable.setBorder(null);
        panelTable.add(new JScrollPane(myTable));

        // creazione frame
        MyFrame myFrame = new MyFrame("database azienda");
        myFrame.add(panelWrapper);
        myFrame.add(panelTable);
        myFrame.pack();
    }
}

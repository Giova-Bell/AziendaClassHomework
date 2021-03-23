package GUI_Component;

import java.awt.Color;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Azienda_Class.Operaio;

@SuppressWarnings("serial")
public class MyTable extends JTable { // crea una tabella standard con l'array di operai passati
    DefaultTableModel operaiTable;
    final DecimalFormat df = new DecimalFormat("0.00");

    public MyTable(Operaio[] operai) {
        this.operaiTable = new DefaultTableModel();
        this.setModel(this.operaiTable);

        // Colonne
        this.operaiTable.addColumn("Numero Matricola");
        this.operaiTable.addColumn("Reparto");
        this.operaiTable.addColumn("Stipendio");
        this.operaiTable.addColumn("Numero Figli");

        this.setBackground(new Color(43, 43, 43));
        this.setForeground(Color.white);
        this.setFillsViewportHeight(true);

        // Righe
        this.df.setRoundingMode(RoundingMode.DOWN);
        for(int i = 0; i < operai.length; ++i) {
            this.operaiTable.insertRow(i, new Object[] { operai[i].numeroMatricola,  operai[i].reparto, df.format(operai[i].stipendio), operai[i].numeroFigliACarico});
        }
    }

    public void refreshTable(Operaio operai[]) { // aggiorna le righe con l'array di operai passato
        this.operaiTable.setRowCount(0);
        this.df.setRoundingMode(RoundingMode.DOWN);
        for(int i = 0; i < operai.length; ++i) {
            this.operaiTable.insertRow(i, new Object[] { operai[i].numeroMatricola,  operai[i].reparto, df.format(operai[i].stipendio), operai[i].numeroFigliACarico});
        }
    }
}

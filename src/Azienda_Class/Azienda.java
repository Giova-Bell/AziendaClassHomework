package Azienda_Class;

import java.util.Arrays;

public class Azienda {
    public Operaio[] operai;

    public Azienda(Operaio[] operai) {
        this.operai = operai;
    }

    // Cerca per numero di matricola
    public Operaio[] cercaMatricole(int numeroMatricola) {
        Operaio[] ris = {};
        for(int i = 0; i < this.operai.length; ++i) {
            if(this.operai[i].numeroMatricola == numeroMatricola) {
                ris = Arrays.copyOf(ris, ris.length + 1);
                ris[ris.length - 1] = this.operai[i];
            }
        }
        return ris;
    }

    // Cerca per reparto
    public Operaio[] cercaReparto(String reparto) {
        Operaio[] ris = {};
        for(int i = 0; i < this.operai.length; ++i) {
            if(this.operai[i].reparto.equals(reparto)) {
                ris = Arrays.copyOf(ris, ris.length + 1);
                ris[ris.length - 1] = this.operai[i];
            }
        }
        return ris;
    }

    // Cerca il numero minore di figli
    private int calcNumeroMinFigli(Operaio[] operai) {
        int min = operai[0].numeroFigliACarico;
        for(int i = 0; i < operai.length; ++i) {
            if(operai[i].numeroFigliACarico < min) {
                min = operai[i].numeroFigliACarico;
            }
        }
        return min;
    }

    // Cerca gli operai con il minor numero di figli
    public Operaio[] stampaDipendentiConMinorNumeroFigli() {
        Operaio[] ris = {};
        int numeroMinFigli = calcNumeroMinFigli(this.operai);
        for(int i = 0; i < this.operai.length; ++i) {
            if(this.operai[i].numeroFigliACarico == numeroMinFigli) {
                ris = Arrays.copyOf(ris, ris.length + 1);
                ris[ris.length - 1] = this.operai[i];
            }
        }
        return ris;
    }

    // Ordina gli operai per matricola
    public void ordinaPerMatricola() {
        int intervallo = this.operai.length / 2;
        while(intervallo > 0) {
            for(int i = intervallo; i < this.operai.length; ++i) {
                Operaio temp = this.operai[i];
                int j = i;
                while(j >= intervallo && operai[j - intervallo].numeroMatricola > temp.numeroMatricola) {
                    operai[j] = operai[j - intervallo];
                    j -= intervallo;
                }
                operai[j] = temp;
            }
            intervallo /= 2;
        }
    }

    // Ordina gli operai per numero di figli
    public void ordinaPerFigli() {
        int intervallo = this.operai.length / 2;
        while(intervallo > 0) {
            for(int i = intervallo; i < this.operai.length; ++i) {
                Operaio temp = this.operai[i];
                int j = i;
                while(j >= intervallo && operai[j - intervallo].numeroFigliACarico > temp.numeroFigliACarico) {
                    operai[j] = operai[j - intervallo];
                    j -= intervallo;
                }
                operai[j] = temp;
            }
            intervallo /= 2;
        }
    }
}

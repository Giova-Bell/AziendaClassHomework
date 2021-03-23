import java.util.Random;

import Azienda_Class.Azienda;
import Azienda_Class.Operaio;
import Views.MainView;

public class App {
    public static void main(String[] args) throws Exception {
        ////////////////////////////////////
        // CREAZIONE DIPENDENTI CASUALI
        ////////////////////////////////////

        /*amministrativa, commerciale, logisatica, manutenzione, produzione*/
        String[] reparti = {"amm", "comm", "log", "man", "prod"};
        Operaio[] operai = new Operaio[5];

        for(int i = 0; i < operai.length; ++i) {
            Random rd = new Random();

            float stipendio = (rd.nextFloat() * 1000.0F) + 1000.0F;
            String reparto = reparti[new Random().nextInt(reparti.length)];
            int numeroFigliACarico = new Random().nextInt(5);
            
            operai[i] = new Operaio(i, stipendio, reparto, numeroFigliACarico);
            operai[i].numeroMatricola = i;
        }
        Azienda azienda = new Azienda(operai);

        
        ///////////////
        // AVVIO GUI
        ///////////////
        new MainView(azienda);
    }
}

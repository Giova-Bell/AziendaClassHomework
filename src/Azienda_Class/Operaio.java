package Azienda_Class;

// usando operaio come struct
public class Operaio {
    public int numeroMatricola;
    public float stipendio;
    public String reparto;
    public int numeroFigliACarico;

    public Operaio(int numeroMatricola, float stipendio, String reparto, int numeroFigliACarico) {
        this.numeroMatricola = numeroMatricola;
        this.stipendio = stipendio;
        this.reparto = reparto;
        this.numeroFigliACarico = numeroFigliACarico;
    }
}

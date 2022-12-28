import java.util.Date;

public class Reserva {
    private String data; // mudar para date
    private String matricula;
    private int nif;
    enum Estado {
        POR_VALIDAR,
        CANCELADA,
        CONCLUIDA
    }
    private Estado estado;

    public Reserva(int nif, String matricula, String data, Estado estado) {
            this.data = "";
            this.nif= nif ;
            this.matricula = matricula;
            this.estado = Estado.POR_VALIDAR;
    }

    public String getData() {
            return data;
    }
    public void setData(String date) {
            this.data = date;
        }
    public void setNif(int nif) {
        this.nif = nif;
    }
    public int getNif() {
        return nif;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Estado getEstado() {
        return estado;
    }
}

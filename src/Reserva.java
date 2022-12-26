public class Reserva {
    private String data; // mudar para date
    private String matricula;
    private int nif;
    enum Estado {
        VALIDA,
        CANCELADA,
        CONCLUIDA
    }
    private Estado estado;

    public Reserva(int nif, String matricula, String data, Estado estado) {
            this.data = "";
            this.nif= nif ;
            this.matricula = matricula;
            this.estado = Estado.VALIDA;
    }
    public String getData() {
            return data;
    }
    public void setData(String data) {
            this.data = data;
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

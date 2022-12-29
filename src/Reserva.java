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



    public String reservas(){

        System.out.println("\n\n*****       Reservas Realizadas          *****");
        System.out.println("\n*************************************************");
        String str = "\n\t\t\t NIF: " +nif;
        str += "\n\t\t\t Data: " +data;
        str += "\n\t\t\t Matrícula: " +matricula;
        str += "\n\t\t\t Estado da Reserva: " +estado;

        return str;
    }

}





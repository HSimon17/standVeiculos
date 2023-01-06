import java.util.Date;

//Classe das Reservas
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

    //Metodo que cria uma reserva
    public Reserva(int nif, String matricula, String data, Estado estado) {
            this.nif = nif;
            this.matricula = matricula;
            this.data = data;
            this.estado = Estado.POR_VALIDAR; // ao criar uma reserva o seu estado passa automaticamente para POR_VALIDAR
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

    //Método que imprime para o ecrã as informações de uma reserva
    public String reservasEfetuadas(){

        String str = "\n\t\t\t NIF: " +nif;
        str += "\n\t\t\t Data: " +data;
        str += "\n\t\t\t Matrícula: " +matricula;
        str += "\n\t\t\t Estado da Reserva: " +estado;

        return str;
    }

}





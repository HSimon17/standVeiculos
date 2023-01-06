//Classe das Vendas
public class Vendas {
    private String data; // mudar para date
    private String matricula;
    private int nif;
    enum Estado {
        VALIDA,
        CANCELADA,
        CONCLUIDA
    }
    private Estado estado;

    //Metodo que cria uma venda
    public Vendas(int nif, String matricula, String data, Estado estado) {
            this.nif= nif ;
            this.matricula = matricula;
            this.data = data;
            this.estado = Estado.CONCLUIDA;
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

    //Método que imprime para o ecrã as informações de uma venda
    public String vendasEfetuadas(){

        String str = "\n\t\t\t NIF: " +nif;
        str += "\n\t\t\t Data: " +data;
        str += "\n\t\t\t Matrícula: " +matricula;
        str += "\n\t\t\t Estado da Compra: " +estado;

        return str;
    }
}

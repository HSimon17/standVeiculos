import java.util.ArrayList;

//Classe dos utilizadores
public class Utilizador {
    private String nome;
    private String apelido;
    private int nif;
    private String email;
    private String password;
    private String cidade;
    private int telemovel;
    private String tipoUser;
    private ArrayList<Reserva> reservas;
    private ArrayList<Vendas> vendas;

    // Construtor que cria um utilizador onde toas as variáveis são obrigatórias
    public Utilizador(String nome, String apelido, String email, String password, int nif, int telemovel, String cidade, String tipoUser) {
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.password = password;
        this.nif = nif;
        this.telemovel = telemovel;
        this.cidade = cidade;
        this.tipoUser = tipoUser;
        this.reservas = new ArrayList<>(); // linha que adiciona reservas ao utilizador
        this.vendas = new ArrayList<>(); // linha que adiciona vendas ao utilizador
    }

    // Método que reserva um automóvel
    public void reservarAutomovel(String matricula, String data){

        Reserva res;

        res = new Reserva(this.nif, matricula, data, Reserva.Estado.POR_VALIDAR); // o nif da reserva é o nif do utilizador logado e o estado da reserva passa automáticamente a POR_VALIDAR

        reservas.add(res); // adicionar a reserva ao array das reservas

    }

    // Método que vende um automóvel
    public void venderAutomovel(int nif, String matricula, String data){

        Vendas venda;

        venda = new Vendas(nif, matricula, data, Vendas.Estado.CONCLUIDA); // o estado da venda passa automaticamente a Concluido o nif é o que o admin selecionar

        vendas.add(venda); //adiciona a venda ao array das vendas

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) { this.nome = nome; }
    public String getApelido(){ return apelido; }
    public void setApelido(String apelido) { this.apelido = apelido; }
    public int getNif() { return nif; }
    public void setNif(int nif) { this.nif = nif; }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getTipoUser() {
        return tipoUser;
    }
    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }
    public int getTelemovel() {
        return telemovel;
    }
    public void setTelemovel(int telemovel) { this.telemovel = telemovel; }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public ArrayList<Reserva> getReservas() { return reservas; }
    public void setReservas(ArrayList<Reserva> reservas) { this.reservas = reservas; }
    public ArrayList<Vendas> getVendas() { return vendas; }
    public void setVendas(ArrayList<Vendas> vendas) { this.vendas = vendas; }

    @Override

    //Método que imprime para o ecrã as informações do perfil + as reservas e vendas efetuadas pelo utilizador
    public String toString(){

        System.out.println("\n\n*****       Informações do Perfil          *****");
        System.out.println("\n*************************************************");
        String str = "\n\t\t\t Tipo de User: " +tipoUser;
        str += "\n\t\t\t Nome: " +nome;
        str += "\n\t\t\t Apelido: " +apelido;
        str += "\n\t\t\t Email: " +email;
        str += "\n\t\t\t Password: " +password;
        str += "\n\t\t\t Cidade:   " +cidade;
        str += "\n\t\t\t Telemóvel: " +telemovel;
        str += "\n\t\t\t NIF: " +nif;

        str += "\n\t\t\tReservas: ";

        for(Reserva r: reservas){
            str += "\t\t\tMatricula: " + r.getMatricula();
            str += "\t\t\tData reserva: " + r.getData();
            str += "\t\t\tEstado da reserva: " + r.getEstado();
            str += "\n\n";
        }

        str += "\n\t\t\tVendas: ";

        for(Vendas venda: vendas){
            str += "\t\t\tMatricula: " + venda.getMatricula();
            str += "\t\t\tData Compra: " + venda.getData();
            str += "\t\t\tEstado da Compra: " + venda.getEstado();
            str += "\n\n";
        }

        return str;
    }

    // Método que dá as boas vindas ao Utilizador
    public String ola(){
        String str = "Olá "+nome;

        return str;
    }

    // Método que lista todos os nifs existentes
    public String nifs(){
        String str = "\n\tNIF: " +nif;

        return str;
    }


}



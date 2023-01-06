import java.util.ArrayList;

//Classe dos Utilizadores
public class Utilizador {
    private String nome;
    private String apelido;
    private int nif;
    private boolean login;
    private String email;
    private String password;
    private String cidade;
    private int telemovel;
    private String tipoUser;
    private ArrayList<Reserva> reservas;

    //Método para adicionar um utilizador em que todas as variáveis são obrigatórias
    public Utilizador(String nome, String apelido, String email, String password, int nif, int telemovel, String cidade, String tipoUser) {
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.password = password;
        this.nif = nif;
        this.telemovel = telemovel;
        this.cidade = cidade;
        this.tipoUser = tipoUser;
        this.reservas = new ArrayList<>(); //linha que adiciona uma lista das reservas ao utilizador
    }

    //Método que cria uma reserva de um automóvel
    public void reservarAutomovel(String matricula, String data){

        Reserva res;

        res = new Reserva(this.nif, matricula, data, Reserva.Estado.POR_VALIDAR); // o nif é o do utilizador logado, dpois só adiciona a matrícula e a data e o estado passa automaticamente a POR_VALIDAR

        reservas.add(res);

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) { this.nome = nome; }
    public String getApelido(){ return apelido; }
    public void setApelido(String apelido) { this.apelido = apelido; }
    public int getNif() { return nif; }
    public void setNif(int nif) { this.nif = nif; }
    public boolean isLogin() { return login; }
    public void setLogin(boolean login) {
        this.login = login;
    }
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

    public String reservasFeitas() {
        int i;
        String str = null;
        for (i = 0; i < reservas.size(); i++) {
            str = "\n\t\t\t NIF: " + reservas.get(i).getNif();
            str += "\n\t\t\t Matrícula: " + reservas.get(i).getMatricula();
            str += "\n\t\t\t Data da Reserva: " + reservas.get(i).getData();
            str += "\n\t\t\t Estado da Reserva: " + reservas.get(i).getEstado();
            str += "\n\n";
        }
        return str;
    }
    @Override

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

        return str;
    }

    public String ola(){
        String str = "Olá "+nome;

        return str;
    }

    public String nifs(){
        String str = "\n\tNIF: " +nif;

        return str;
    }


}



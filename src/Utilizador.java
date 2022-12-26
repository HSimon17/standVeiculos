import java.util.ArrayList;

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

    public Utilizador(){
        this.nome = "";
        this.apelido = "";
        this.nif = 0;
        this.login = true;
        this.cidade = "";
        this.telemovel = 0;
        this.tipoUser = "";
        this.email = "";
        this.password = "";
    }

    public Utilizador(String nome, String apelido, String email, String password, int nif, int telemovel, String cidade, String tipoUser) {
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.password = password;
        this.nif = nif;
        this.telemovel = telemovel;
        this.cidade = cidade;
        this.tipoUser = tipoUser;
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

        return str;
    }

    public String ola(){
        String str = "Olá "+nome +apelido;

        return str;
    }
}

public class Acao {
    private String nomeAcao;
    private String dataHora; // passar para data
    private int email; // usar o username para identificar o utilizador

    public Acao (String nomeAcao, String dataHora, int email){
        this.nomeAcao = nomeAcao;
        this.dataHora = dataHora;
        this.email = email;
    }
}

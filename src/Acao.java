public class Acao {
    private String nomeAcao;
    private String dataHora; // passar para data
    private int nif; // usar o username para identificar o utilizador

    public Acao (String nomeAcao, String dataHora, int nif){
        this.nomeAcao = nomeAcao;
        this.dataHora = dataHora;
        this.nif = nif;
    }
}

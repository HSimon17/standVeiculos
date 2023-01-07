import java.util.Date;

// Classe das Ações
public class Acao {

    private String nomeAcao;
    private Date dataHora;
    private int nif;

    // Construtor que cria uma ação
    public Acao (String nomeAcao, int nif){
        this.nif = nif;
        this.nomeAcao = nomeAcao;
        this.dataHora = new Date();
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getNif() { return nif; }

    public void setNif(int nif) { this.nif = nif; }

}

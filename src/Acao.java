import java.util.Date;

public class Acao {

    private String nomeAcao;
    private Date dataHora; // passar para data

    public Acao (String nomeAcao){
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

   /* public String acoesEfetuadas(){

        String str = "\n\t\t\t Ação: " +nomeAcao;
        str += "\n\t\t\t Data: " +dataHora;

        return str;
    } */

}

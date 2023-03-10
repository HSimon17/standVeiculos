import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

// Classe dos Automóveis
public class Automovel {
    enum Estado {
        DISPONIVEL,
        RESERVADO,
        VENDIDO,
        DESATIVO
    }

    private String matricula;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private float preco;
    private float kms;
    private Estado estado;
    private HashMap<Object, Automovel> automovel;


    //Construtor para criar um automóvel onde todas as variáveis são obrigatórias
    public Automovel(String matricula, String marca, String modelo, String cor, int ano, float kms, float preco) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.kms = kms;
        this.preco = preco;
        this.estado = Estado.DISPONIVEL; // quando se cria um automóvel o seu estado é automaticamente Disponivel
    }

    public String getMatricula() {
        return this.matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public int getAno() {
        return this.ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public float getPreco() {
        return this.preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public float getKms() {
        return kms;
    }
    public void setKms(float kms) {
        this.kms = kms;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public HashMap<Object, Automovel> getAutomovel() {
        return automovel;
    }
    public void setAutomovel(HashMap<Object, Automovel> automovel) {
        this.automovel = automovel;
    }

    //Método que imprime para o ecrã as informações dos automóveis
    @Override
    public String toString(){
        System.out.println("\n\n**********     Informações do Automóvel      **********");
        String str = "\n\t\t\tMatricula: " +matricula;
        str += "\n\t\t\tMarca: " +marca;
        str += "\n\t\t\tModelo: " +modelo;
        str += "\n\t\t\tCor: " +cor;
        str += "\n\t\t\tAno: " +ano;
        str += "\n\t\t\tKms: " +kms;
        str += "\n\t\t\tPreço: " +preco;
        str += "\n\t\t\tEstado: " +estado;
        return str;

    }

    //Método que lista as matriculas dos automóveis
    public String matriculas(){
        String str = "\n\tMatricula: " +matricula;

        return str;
    }
}
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

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


    public Automovel(String matricula, String marca, String modelo, String cor, int ano, float kms, float preco) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.kms = kms;
        this.preco = preco;
        this.estado = Estado.DISPONIVEL;
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

    @Override
    public String toString(){

        String str = "\n\tMatricula: " +matricula;
        str += "\n\tMarca: " +marca;
        str += "\n\tModelo: " +modelo;
        str += "\n\tCor: " +cor;
        str += "\n\tAno: " +ano;
        str += "\n\tKms: " +kms;
        str += "\n\tPreço: " +preco;
        str += "\n\tEstado: " +estado;
        return str;

    }
}
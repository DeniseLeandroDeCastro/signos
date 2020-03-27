package mobile.ifrn.edu.signos;

//Esta é a classe central da aplicação


import java.io.Serializable;

public class Signo implements Serializable {
    //Atributos da classe, todos privados
    private int diainicio;
    private int diafim;
    private int mesinicio;
    private int mesfim;
    private String nome;
    private String imagem;

    //Construtor vazio - regra p/toda classe que implementa Serializable
    public Signo() {}

    //Sobrecarga no construtor(Já passa no construtor os atributos que a classe terá)
    public Signo(int diainicio, int mesinicio, int diafim, int mesfim, String nome, String imagem) {
        this.diainicio = diainicio;
        this.diafim = diafim;
        this.mesinicio = mesinicio;
        this.mesfim = mesfim;
        this.nome = nome;
        this.imagem = imagem;
    }

    //Método acessor getter - não precisa do setter devido ao uso da sobrecarga no construtor
    public int getDiainicio() {
        return diainicio;
    }

    public int getDiafim() {
        return diafim;
    }

    public int getMesinicio() {
        return mesinicio;
    }

    public int getMesfim() {
        return mesfim;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }
}

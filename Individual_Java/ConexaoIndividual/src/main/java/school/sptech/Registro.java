package school.sptech;

import java.time.LocalDateTime;

public class Registro {
    private String sistemaOperacional;
    private String fabricante;
    private String arquitetura;
    private LocalDateTime inicializado;
    private String nome;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(String arquitetura) {
        this.arquitetura = arquitetura;
    }

    public LocalDateTime getInicializado() {
        return inicializado;
    }

    public void setInicializado(LocalDateTime inicializado) {
        this.inicializado = inicializado;
    }

    @Override
    public String toString() {
        return "Registro {" +
                "sistemaOperacional='" + sistemaOperacional + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", arquitetura='" + arquitetura + '\'' +
                ", inicializado=" + inicializado +
                '}';
    }
}



package padroes.prototype.aeroporto;

public class Terminal implements Cloneable {
    private String nome;
    private Integer portao;

    public Terminal(String nome, Integer portao) {
        super();
        this.nome = nome;
        this.portao = portao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPortao() {
        return portao;
    }

    public void setPortao(Integer portao) {
        this.portao = portao;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Terminal{" +
                "nome='" + nome + '\'' +
                ", portao=" + portao +
                '}';
    }
}

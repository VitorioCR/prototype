package padroes.prototype.aeroporto;

public class Voo implements Cloneable {
    private String codigo;
    private String destino;
    private Terminal terminal;
    private String companhia;

    public Voo(String codigo, String destino, Terminal terminal, String companhia) {
        this.codigo = codigo;
        this.destino = destino;
        this.terminal = terminal;
        this.companhia = companhia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    @Override
    public Voo clone() throws CloneNotSupportedException {
        Voo vooClone = (Voo) super.clone();
        vooClone.terminal = (Terminal) vooClone.terminal.clone();
        return vooClone;
    }

    @Override
    public String toString() {
        return "Voo{" +
                "codigo='" + codigo + '\'' +
                ", destino='" + destino + '\'' +
                ", terminal=" + terminal +
                ", companhia='" + companhia + '\'' +
                '}';
    }
}

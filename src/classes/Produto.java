package classes;

public class Produto {
    private String descricao;
    private double preco;
    private int estoque;
    private int codigoProprio;
    private String dataHora;

    public Produto(String descricao, double preco, int estoque, int codigoProprio) {
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.codigoProprio = codigoProprio;
    }

    public int getCodigoProprio() {
        return codigoProprio;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "\nDescrição: " + descricao + ", \nPreço: " + preco + ", \nEstoque: " + estoque + ", \nCódigo Próprio: " + codigoProprio + ", \nData e Hora: " + dataHora;
    }
}

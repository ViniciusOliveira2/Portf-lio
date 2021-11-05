package fatec.poo.model;

/**
 *
 * @author vinicius
 */
public class APrazo {
    private double valor;
    private double taxaJuros;
    private String dtVencimento;
    private int qtdeMensalidade;

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros / 100;
    }

    public void setDtVencimento(String dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public void setQtdeMensalidade(int qtdeMensalidade) {
        this.qtdeMensalidade = qtdeMensalidade;
    }
}
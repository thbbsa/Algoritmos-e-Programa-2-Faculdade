public class Divida {

    private String nomeDevedor;
    private double divida;
    private double juros;
    private double multa;
    private double valorPagar;
    private int diasAtraso;

    private final double TAXAJUROS = 0.00033;
    private final double TAXAMULTA = 0.02;

    // calculo
    public void calculo() {

        juros = diasAtraso * TAXAJUROS * divida;

        multa = TAXAMULTA * divida;

        valorPagar = multa + juros + divida;
    }

    // Getters e Setters

    public String getNomeDevedor() {
        return nomeDevedor;
    }

    public void setNomeDevedor(String nomeDevedor) {
        this.nomeDevedor = nomeDevedor;
    }

    public double getDivida() {
        return divida;
    }

    public void setDivida(double divida) {
        this.divida = divida;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public static void main(String[] args) {
        Divida d = new Divida();

        d.setNomeDevedor("João");
        d.setDivida(1000);
        d.setDiasAtraso(10);

        d.calculo();

        System.out.println("Juros: " + d.getJuros());
        System.out.println("Multa: " + d.getMulta());
        System.out.println("Valor a pagar: " + d.getValorPagar());
    }
}

public class TanqueCombustivel {
    private TipoCombustivel tipoCombustivel;
    // Se o tipoCombustivel for flex, o tipoCombustivelArmazenado pode ser gasolina ou alcool
    private TipoCombustivel tipoCombustivelArmazenado;
    private int capacidade;
    private int combustivelDisponivel;

    public TanqueCombustivel(TipoCombustivel tipoCombustivel, int capacidade) {
        this.tipoCombustivel = tipoCombustivel;
        this.tipoCombustivelArmazenado = null;
        this.capacidade = capacidade;
        this.combustivelDisponivel = 0;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public TipoCombustivel getTipoCombustivelArmazenado() {
        return tipoCombustivelArmazenado;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getCombustivelDisponivel() {
        return combustivelDisponivel;
    }

    // Retorna false se o tipo de combustivel for incompativel ou se a quantidade
    // for maior que a capacidade livre
    public boolean abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        this.tipoCombustivelArmazenado = tipoCombustivel;
        if (tipoCombustivel != this.tipoCombustivel) {
            if (this.tipoCombustivel == TipoCombustivel.FLEX) {
                if (!(tipoCombustivel == TipoCombustivel.GASOLINA || tipoCombustivel == TipoCombustivel.ALCOOL)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (getCombustivelDisponivel() + quantidade > getCapacidade()) {
            return false;
        } else {
            combustivelDisponivel += quantidade;
            return true;
        }
    }

    public boolean gasta(int quantidade) {
        if (getCombustivelDisponivel() - quantidade < 0) {
            return false;
        } else {
            combustivelDisponivel -= quantidade;
            return true;
        }
    }

    @Override
    public String toString() {
        return "TanqueCombustivel [capacidade=" + capacidade + ", combustivelDisponivel=" + combustivelDisponivel
                + ", tipoCombustivel=" + tipoCombustivel + ", tipoCombustivelNoTanque=" + tipoCombustivelArmazenado + "]";
    }
}
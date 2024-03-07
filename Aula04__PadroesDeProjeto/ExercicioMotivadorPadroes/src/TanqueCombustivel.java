import java.util.Arrays;
import java.util.Map;

public class TanqueCombustivel {
    private Map<TipoCombustivel, int> capacidadePorTipoCombustivel;
    private int combustivelDisponivel;

    public TanqueCombustivel(Map<TipoCombustivel, int> capacidadePorTipoCombustivel) {
        this.capacidadePorTipoCombustivel = capacidadePorTipoCombustivel;
        this.combustivelDisponivel = 0;
    }

    public Array<TipoCombustivel> getTiposCombustivel() {
        return capacidadePorTipoCombustivel.keys();
    }

    public Map<TipoCombustivel, int> getCapacidadePorTipoDeCombustivel() {
        return this.capacidadePorTipoCombustivel;
    }

    public int getCapacidade(TipoCombustivel tipoCombustivel) {
        return capacidade.get(tipoCombustivel);
    }

    public int getCombustivelDisponivel() {
        return combustivelDisponivel;
    }

    // Retorna false se o tipo de combustivel for incompativel ou se a quantidade
    // for maior que a capacidade livre
    public boolean abastece(TipoCombustivel tipoCombustivel, int quantidade) {
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
                + ", tipoCombustivel=" + tipoCombustivel + "]";
    }
}
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Motor {
    private Map<TipoCombustivel, Integer> consumoPorTipoCombustivel;
    private int quilometragem;

    public Motor(TipoCombustivel tipoMotor, int consumo) {
        Map<TipoCombustivel, Integer> consumoPorTipoCombustivel = new HashMap<TipoCombustivel, Integer>(1);
        consumoPorTipoCombustivel.put(tipoMotor, consumo);
        this.consumoPorTipoCombustivel = consumoPorTipoCombustivel;
    }

    public Motor(Map<TipoCombustivel, Integer> consumoPorTipoCombustivel) {
        this.consumoPorTipoCombustivel = consumoPorTipoCombustivel;
    }

    public int getConsumo() {
        if (consumoPorTipoCombustivel.size() != 1) {
            throw new IllegalStateException("Motor com mais de um tipo de combustivel. Favor explicitar o tipo desejado.");
        }
        return consumoPorTipoCombustivel.values().iterator().next();
    }

    public int getConsumo(TipoCombustivel tipoCombustivel) {
        return consumoPorTipoCombustivel.get(tipoCombustivel);
    }

    public Set<TipoCombustivel> getTiposCombustivelMotor() {
        return consumoPorTipoCombustivel.keySet();
    }

    public int getQuilometragem(){
        return this.quilometragem;
    }

    public int combustivelNecessario(int distancia, TipoCombustivel tipoCombustivel) {
        int consumo = consumoPorTipoCombustivel.get(tipoCombustivel);
        return distancia / consumo;
    }

    public void percorre(int distancia) {
        quilometragem += distancia;
    }

    private String getConsumoPorTipoCombustivel() {
        return consumoPorTipoCombustivel.toString();
    }

    private String getTiposCombustivelMotorString() {
        return consumoPorTipoCombustivel.keySet().toString();
    }

    @Override
    public String toString() {
        return "Motor [consumo=" + getConsumoPorTipoCombustivel() + ", quilometragem=" + quilometragem + ", tipoMotor=" + getTiposCombustivelMotorString() + "]";
    }
}
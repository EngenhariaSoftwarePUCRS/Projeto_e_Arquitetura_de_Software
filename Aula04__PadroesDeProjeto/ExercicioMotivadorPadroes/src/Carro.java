import java.util.Map;

public class Carro {
    private String modelo;
    private Motor motor;
    private TanqueCombustivel tanque;

    /**
     * Construtor para carros com motor de um único tipo de combustivel
     */
    public Carro(
        String modelo,
        int capacidadeTanque,
        TipoCombustivel tipoCombustivelTanque,
        TipoCombustivel tipoCombustivelMotor,
        int consumoMotor
    ) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivelMotor, consumoMotor);
        tanque = new TanqueCombustivel(tipoCombustivelTanque, capacidadeTanque);
    }

    /**
     * Construtor para carros com motor flex
     */
    public Carro(
        String modelo,
        int capacidadeTanque,
        Map<TipoCombustivel, Integer> consumoPorTipoCombustivelMotor
    ) {
        this.modelo = modelo;
        motor = new Motor(consumoPorTipoCombustivelMotor);
        tanque = new TanqueCombustivel(TipoCombustivel.FLEX, capacidadeTanque);
    }

    /**
     * Construtor para carros com consumo que decai ao longo do tempo
     * 
     * *consumo/decaimento em Litros por Km
     */
    public Carro(
        String modelo,
        int capacidadeTanque,
        TipoCombustivel tipoCombustivel,
        int consumoNovo,
        int consumoEstabilizado,
        Map<Integer, Integer> decaimentoPorKmAndado
    ) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel, consumoNovo, consumoEstabilizado, decaimentoPorKmAndado);
        tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }

    public String getModelo() {
        return modelo;
    }

    public int getCombustivelDisponivel() {
        return tanque.getCombustivelDisponivel();
    }

    // Retorna a quantidade efetivamente abastecida
    public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        int capacidadeLivre = tanque.getCapacidade() - tanque.getCombustivelDisponivel();
        if (capacidadeLivre < quantidade) {
            quantidade = capacidadeLivre;
        }
        tanque.abastece(tipoCombustivel, quantidade);
        return quantidade;
    }

    // Retorna a distancia que consegue viajar com o combustivel remanescente
    public int verificaSePodeViajar(int distancia) {
        TipoCombustivel tipoCombustivelNoTanque = tanque.getTipoCombustivelArmazenado();
        int combustivelNecessario = motor.combustivelNecessario(distancia, tipoCombustivelNoTanque);
        if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
            return distancia;
        }
        return tanque.getCombustivelDisponivel() * motor.getConsumo(tipoCombustivelNoTanque);
    }

    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) < distancia) {
            return false;
        }
        TipoCombustivel tipoCombustivelNoTanque = tanque.getTipoCombustivelArmazenado();
        motor.percorre(distancia);
        tanque.gasta(motor.combustivelNecessario(distancia, tipoCombustivelNoTanque));
        return true;
    }

    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
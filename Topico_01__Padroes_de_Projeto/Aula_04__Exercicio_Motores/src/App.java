import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Carro basico = new Carro("Basico", 55, TipoCombustivel.GASOLINA, TipoCombustivel.GASOLINA, 10);
        Carro esportivo = new Carro("Esportivo", 45, TipoCombustivel.GASOLINA, TipoCombustivel.GASOLINA, 6);
        Carro utilitario = new Carro("Utilitario", 70, TipoCombustivel.DIESEL, TipoCombustivel.DIESEL, 5);
        Map<TipoCombustivel, Integer> consumoGasolinaSuv = new HashMap<TipoCombustivel, Integer>();
        consumoGasolinaSuv.put(TipoCombustivel.GASOLINA, 8);
        Carro suv = new Carro("SUV", 55, consumoGasolinaSuv);
        Map<TipoCombustivel, Integer> consumoGasolinaSuvFlex = new HashMap<TipoCombustivel, Integer>();
        consumoGasolinaSuvFlex.put(TipoCombustivel.GASOLINA, 8);
        consumoGasolinaSuvFlex.put(TipoCombustivel.ALCOOL, 6);
        Carro suvFlex = new Carro("SUVFlex", 65, consumoGasolinaSuvFlex);
        Map<Integer, Integer> decaimentoPorKmAndado = new HashMap<Integer, Integer>();
        decaimentoPorKmAndado.put(5000, 1);
        Carro econo = new Carro("Econo", 55, TipoCombustivel.GASOLINA, 20, 10, decaimentoPorKmAndado);

        Carro[] cars = {basico, esportivo, utilitario, suv, suvFlex, econo};
        printCars(cars);

        testInstance(basico, TipoCombustivel.GASOLINA, 55, 400);
        testInstance(esportivo, TipoCombustivel.GASOLINA, 45, 250);
        testInstance(utilitario, TipoCombustivel.DIESEL, 70, 520);
        testInstance(suv, TipoCombustivel.GASOLINA, 55, 250);
        testInstance(suvFlex, TipoCombustivel.ALCOOL, 65, 300);
        testInstance(econo, TipoCombustivel.GASOLINA, 55, 400);
    }

    private static void testInstance(Carro car, TipoCombustivel gasType, int gasAmount, int driveDistance) {
        putGas(car, gasType, gasAmount);
        System.out.println(car);
        drive(car, driveDistance);
        System.out.println(car);
    }

    private static void printCars(Carro[] cars) {
        System.out.println("Tipos de veiculos:");
        for (Carro car : cars) {
            System.out.println(car);
        }
    }

    private static void putGas(Carro car, TipoCombustivel gasType, int amount) {
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro " + car.getModelo() + " com " + amount + "L de " + gasType.toString());
        car.abastece(gasType, amount);
    }

    private static void drive(Carro car, int distance) {
        System.out.println("\nViajando com o carro " + car.getModelo());
        car.viaja(distance);
    }
}

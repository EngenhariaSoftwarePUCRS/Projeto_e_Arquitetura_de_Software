public class App {
    public static void main(String[] args) throws Exception {
        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55);

        Carro[] cars = {basico};
        printCars(cars);

        putGas(basico, TipoCombustivel.GASOLINA, 55);
        System.out.println(basico);
        drive(basico, 400);
        System.out.println(basico);
    }

    private static void printCars(Carro[] cars) {
        System.out.println("Tipos de veiculos:");
        for (Carro car : cars) {
            System.out.println(car);
        }
    }

    private static void putGas(Carro car, TipoCombustivel gasType, int amount) {
        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro basico com gasolina");
        car.abastece(gasType, amount);
    }

    private static void drive(Carro car, int distance) {
        System.out.println("\nViajando com o carro " + car.getModelo());
        car.viaja(distance);
    }
}

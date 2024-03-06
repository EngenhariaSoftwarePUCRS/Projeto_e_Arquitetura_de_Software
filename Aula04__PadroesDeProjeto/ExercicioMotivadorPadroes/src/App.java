public class App {
    public static void main(String[] args) throws Exception {
        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55);
        Carro esportivo = new Carro("Esportivo", TipoCombustivel.GASOLINA, 6, 45);
        Carro utilitario = new Carro("Utilitario", TipoCombustivel.DIESEL, 5, 70);

        Carro[] cars = {basico, esportivo, utilitario};
        printCars(cars);

        testInstance(basico, TipoCombustivel.GASOLINA, 55, 400);
        testInstance(esportivo, TipoCombustivel.GASOLINA, 45, 250);
        testInstance(utilitario, TipoCombustivel.DIESEL, 70, 520);
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
        System.out.println("\nAbastencendo carro " + car.getModelo() + " com " + gasType.toString());
        car.abastece(gasType, amount);
    }

    private static void drive(Carro car, int distance) {
        System.out.println("\nViajando com o carro " + car.getModelo());
        car.viaja(distance);
    }
}

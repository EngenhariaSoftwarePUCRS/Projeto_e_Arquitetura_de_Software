public class App {
    public static void main(String[] args) throws Exception {
        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, TipoCombustivel.GASOLINA, 10, 55);
        Carro esportivo = new Carro("Esportivo", TipoCombustivel.GASOLINA, TipoCombustivel.GASOLINA, 6, 45);
        Carro utilitario = new Carro("Utilitario", TipoCombustivel.DIESEL, TipoCombustivel.DIESEL, 5, 70);
        Carro suv = new Carro("SUV", TipoCombustivel.GASOLINA, TipoCombustivel.FLEX, 8, 55);
        Carro suvFlex = new Carro("SUVFlex", TipoCombustivel.FLEX, TipoCombustivel.FLEX, 8, 55);

        Carro[] cars = {basico, esportivo, utilitario, suv};
        printCars(cars);

        testInstance(basico, TipoCombustivel.GASOLINA, 55, 400);
        testInstance(esportivo, TipoCombustivel.GASOLINA, 45, 250);
        testInstance(utilitario, TipoCombustivel.DIESEL, 70, 520);
        testInstance(suv, TipoCombustivel.GASOLINA, 55, 250);
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

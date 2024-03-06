public class App {
    public static void main(String[] args) throws Exception {
        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55);

        Carro[] cars = {basico};
        printCars(cars);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro basico com gasolina");
        basico.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(basico);
        System.out.println("\nViajando com o carro basico");
        basico.viaja(250);
        basico.viaja(150);
        System.out.println(basico);
    }

    private static void printCars(Carro[] cars) {
        System.out.println("Tipos de veiculos:");
        for (Carro car : cars) {
            System.out.println(car);
        }
    }
}

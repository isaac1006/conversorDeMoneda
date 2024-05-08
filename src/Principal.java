import java.util.Scanner;

public class Principal extends ConvirtiendoMoneda {
    public static void main(String[] args) {
        ConvirtiendoMoneda conversor = new ConvirtiendoMoneda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú de Conversión de Moneda:");
            System.out.println("1. USD a ARS (Peso Argentino)");
            System.out.println("2. USD a BRL (Real Brasileño)");
            System.out.println("3. BRL a USD (Dólar)");
            System.out.println("4. USD a COP (Peso Colombiano)");
            System.out.println("5. COP a USD (Dólar)");
            System.out.println("6. Salir");

            System.out.print("\nIngrese el número de opción (1-6): ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarConversion(conversor, "USD", "ARS");
                    break;
                case 2:
                    realizarConversion(conversor, "USD", "BRL");
                    break;
                case 3:
                    realizarConversion(conversor, "BRL", "USD");
                    break;
                case 4:
                    realizarConversion(conversor, "USD", "COP");
                    break;
                case 5:
                    realizarConversion(conversor, "COP", "USD");
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número de opción válido (1-6).");
            }
        }
    }

    private static void realizarConversion(ConvirtiendoMoneda conversor, String monedaOrigen, String monedaDestino) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        double cantidadConvertida = conversor.convertirMoneda(cantidad, monedaOrigen, monedaDestino);
        System.out.println(cantidad + " " + monedaOrigen + " equivale a " + cantidadConvertida + " " + monedaDestino);
    }
}
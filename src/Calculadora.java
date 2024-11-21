import java.util.Scanner;

public class Calculadora {
    public void menuCalculadora() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("Menú de calculadora");
                System.out.println("1. Suma");
                System.out.println("2. División");
                System.out.println("3. Multiplicación");
                System.out.println("4. Exponenciación");
                System.out.println("5. Salir");
                System.out.println("Elige una operación:");
                int opcion = scanner.nextInt();

                if (opcion == 5) {
                    continuar = false;
                    System.out.println("Saliendo...");
                    break;
                }

                System.out.println("Ingresa la cantidad de números para la operación:");
                int n = scanner.nextInt();
                if (n <= 0) {
                    throw new IllegalArgumentException("La cantidad de números debe ser mayor a 0.");
                }

                double[] numeros = new double[n];

                for (int i = 0; i < n; i++) {
                    System.out.print("Ingresa el número " + (i + 1) + ": ");
                    numeros[i] = scanner.nextDouble();
                }

                switch (opcion) {
                    case 1:
                        System.out.println("Resultado de la suma: " + sumar(numeros));
                        break;
                    case 2:
                        System.out.println("Resultado de la división: " + dividir(numeros));
                        break;
                    case 3:
                        System.out.println("Resultado de la multiplicación: " + multiplicar(numeros));
                        break;
                    case 4:
                        System.out.println("Resultado de la exponenciación: " + exponenciar(numeros));
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }

    public static double sumar(double[] numeros) {
        double suma = 0;
        for (double numero : numeros) {
            suma += numero;
        }
        return suma;
    }

    public static double dividir(double[] numeros) {
        try {
            double resultado = numeros[0];
            for (int i = 1; i < numeros.length; i++) {
                if (numeros[i] == 0) {
                    throw new ArithmeticException("División por cero no permitida.");
                }
                resultado /= numeros[i];
            }
            return resultado;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return Double.NaN;
        }
    }

    public static double multiplicar(double[] numeros) {
        double producto = 1;
        for (double numero : numeros) {
            producto *= numero;
        }
        return producto;
    }

    public static double exponenciar(double[] numeros) {
        try {
            if (numeros.length < 2) {
                throw new IllegalArgumentException("La exponenciación requiere al menos dos números.");
            }
            double base = numeros[0];
            double exponente = numeros[1];
            return Math.pow(base, exponente);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return Double.NaN;
        }
    }
}

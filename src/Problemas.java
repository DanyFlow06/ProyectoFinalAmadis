import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class Problemas {
    
    public static void main(String[] args) throws Exception {
        Scanner k = new Scanner(System.in);
        

        boolean continuarPrograma = true;
        char seleccionWhile;
        int seleccionPrograma;
        while (continuarPrograma) {
            System.out.println("Bienvenido a nuestro programa");
            
            System.out.println("Lista de problemas.");
            System.out.println("[1] Calculadora");
            System.out.println("[2] Problema 2");
            System.out.println("[5] Problema 5");
            System.out.println("[7] Problema 7");
            System.out.println("[10] Problema 17");
            System.out.println("Selecciona el problema: ");

            seleccionPrograma = k.nextInt();

            switch (seleccionPrograma) {
                case 1:
                    // Ejecutar calculadora programa N1
                    Calculadora();
                    break;
                case 2:
                    //Problema2();
                    break;
                case 5:
                    Problema5();
                    break;
                case 7:
                    Problema7();
                    break;
                case 10:
                    Problema17();
                    break;        

                // TODOS LOS CASOS ABAJO ->
            
                default:
                    break;
            }


            // Pregunta si continuar el programa
            try {
                System.out.println("¿Quieres continuar al menú principal? [s/n] (s=si, n=no)");
                seleccionWhile = k.next().toLowerCase().charAt(0);
                continuarPrograma = (seleccionWhile == 's') ? true : false;
                limpiarConsola();
                
            } catch (Exception e) {
                System.out.println("Debes ingresar solo números (0-1)");
                break;
            }
        }

        
    }


    static void Calculadora(){
        Calculadora calc = new Calculadora();
        calc.menuCalculadora();
    }


    static void Problema17() {
        Scanner k = new Scanner(System.in);
        Random rnd = new Random();

        /*
         * 17. Se necesita generar un vector de 50 elementos con valores numéricos enteros (imprima el
         * vector lleno, el usuario no lo llena), realice lo siguiente:
         * a. Leer un valor x y buscar en qué posición del vector se encuentra
         * b. Llene otro vector con los elementos de las posiciones impares del vector.
         * c. En este último vector, busque cuántos elementos son múltiplos de 3 Puntos: 1
         */

        // Declaración de variables
        int vector[] = new int[50];
        int numX; // Número a buscar en el vector
        int posX = -1; // Posición del número a buscar en el vector, inicializada a -1

        // Llenar vector con números enteros aleatorios entre 1-100
        // Mostrar el vector lleno
        for (int i = 0; i < vector.length; i++) {
            vector[i] = rnd.nextInt(100) + 1; // valores entre 1 y 100
            System.out.println("Posición " + i + ": " + vector[i]);
        }

        System.out.println("Ingresa el número a buscar en el vector de 50 números:");
        numX = k.nextInt();

        // Buscar el número en el vector
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == numX) {
                posX = i;
                break;
            }
        }
        if (posX != -1) {
            System.out.println("El número " + numX + " se encuentra en la posición " + posX);
        } else {
            System.out.println("El número " + numX + " no se encuentra en el vector");
        }

        // Llenar otro vector con los elementos de las posiciones impares del vector
        int vectorImpares[] = new int[25];
        int j = 0;
        for (int i = 1; i < vector.length; i += 2) {
            vectorImpares[j] = vector[i];
            j++;
        }

        // Mostrar el vector con los elementos de las posiciones impares
        System.out.println("Vector con elementos en posiciones impares:");
        System.out.print("[");
        for (int i = 0; i < vectorImpares.length; i++) {
            System.out.print("" + vectorImpares[i] + ", ");
        }
        System.out.println("]");

        // Buscar cuántos elementos son múltiplos de 3
        int multiplos3 = 0;
        for (int i = 0; i < vectorImpares.length; i++) {
            if (vectorImpares[i] % 3 == 0) {
                multiplos3++;
            }
        }

        System.out.println("En el vector de posiciones impares hay " + multiplos3 + " elementos múltiplos de 3");
    }

    static void Problema5(){
        Scanner k = new Scanner(System.in);
        // 5. Implementa la función exponencial: Taylor
        
        // Declarar variables
        int x; // valor x de la formula
        int n; // Número de terminos de la sucesión
        double resultado; // Variable para guardar el resultado
        double t = 1.0; // El primer termino es 1
        double suma = 1.0; // Variable para ir sumando los valores de la serie

        // Pedir valores al usuario
        System.out.println("Ingrese el valor de x: ");
        x = k.nextInt();

        System.out.println("Ingrese el número de terminos de la serie de Taylor: ");
        n = k.nextInt();

        // Ciclo para realizar la serie
        for (int i = 1; i < n; i++) {
            t = t * x / i; // calcular termino de la sucesion
            suma += t; // Añade los terminos de la sucesion y los suma
        }
        resultado = suma;
        
        // Imprimir el resultado de la serie
        System.out.println("El valor aproximaodo de e^" + x + " es: " + resultado);
        
    }
    static void Problema7(){
        /* 7. En 1951, una persona vendió las tierras de su abuelo al gobierno por la cantidad de $1500.
        Suponga que esta persona ha colocado el dinero en una cuenta de ahorros que paga 15% anual.
        ¿Cuánto vale ahora su inversión? P(1+i)^n. */
        
        // Declarar variables
        BigDecimal r; // Es el monto final
        BigDecimal p = new BigDecimal("1500"); // Cantidad inicial de dinero
        BigDecimal i = new BigDecimal("0.15"); // tasa de interés anual
        int n = 2024 - 1951; // cantidad de años

        // Para realizar la suma del parentesis
        BigDecimal uno = new BigDecimal("1");
        
        // realizar calculo
        r = uno.add(i); // realizar la operación que está dentro del parentesis: (1 + i) = (1 + 0.15)
        r = r.pow(n); // Realizar exponente: (1.15)^73
        r = p.multiply(r); // realizar la multiplicación en este caso: 1500 * 26973.81

        // Imprimir resultado
        System.out.println("El monto de la inversion en 2024 es: " + "$" + r);
    }

    public static void limpiarConsola() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

}





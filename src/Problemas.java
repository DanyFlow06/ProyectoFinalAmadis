import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Problemas {
    
    public static void main(String[] args) throws Exception {
        Scanner k = new Scanner(System.in);
        

        boolean continuarPrograma = true;
        char seleccionWhile;
        
        while (continuarPrograma) {

            mainMenu();

            int seleccionPrograma = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    seleccionPrograma = k.nextInt();
                    validInput = true;
                } catch (Exception e) {
                    limpiarConsola();
                    mainMenu();
                    System.out.println("Ingresaste un valor no válido, intenta de nuevo: ");
                    k.next(); // Limpiar el buffer del scanner
                }
            }

            switch (seleccionPrograma) {
                case 1:
                    // Ejecutar calculadora programa N1
                    System.out.println("\nCalculadora permite realizar sumas, división, multiplicación y\nexponienciación de los números que desee.\n");
                    Calculadora(); // 1 pto
                    break;
                case 2:
                    System.out.println("\nEn letras del abecedario usted ingresará un número entre el 1 - 26\ny se imprimirá la letra correspondiente (Ejemplo: 3 = C)\n");
                    Problema10(); // 1 pto
                    break;
                case 3:
                    System.out.println("\nHistograma de datos permite introducir n cantidad de elementos, el\nprograma mostrara un histograma de esos datos (el histograma se\ninterpretara con la salida de n asteriscos donde n es el valor\nde cada elemento del arreglo) ej: el arreglo es 2,3,4 el\nhistograma será 2->**3->***4->****\n");                        
                    Problema11(); // 1 pto
                    break;
                case 4:
                    System.out.println("\nIngresa 8 digitos y el programa los va a intercambiar\nde lugar (Ejemplo:| 1 | 2 | 3 | = | 3 | 2 | 1 | )\n");
                    Problema12(); // 1 pto
                    break;
                case 5:
                    System.out.println("\nEste algoritmo implementa la función exponencial de Taylor del tamaño que desee\n");
                    Problema5(); // 2 ptos
                    break;
                case 6:
                    System.out.println("\nInvertir un arreglo de n elementos le pertmite ingresar la cantidad de números que\ndesee e invertirlos en orden\n");
                    Problema13(); // 2 ptos
                    break;
                case 7:
                    System.out.println("\nEn este algoritmo se calcula cuanto tiene actualmente (2024) una persona que en 1951\ntenía $1500 en una cuenta de ahorro con una tasa anual del 15%.\n");
                    Problema7(); // 1 pto
                    break;
                case 8:
                    Problema17(); // 1 pto
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

    static void mainMenu(){
        System.out.println("Bienvenido a nuestro programa");
            
            System.out.println("Lista de problemas.");
            System.out.println("[1] Calculadora");
            System.out.println("[2] Letras del abecedario");
            System.out.println("[3] Histograma de datos");
            System.out.println("[4] Intercambiar posiciones de un arreglo");
            System.out.println("[5] Funcion exponencial: Taylor");
            System.out.println("[6] Invertir un arreglo de n elementos");
            System.out.println("[7] Valor de inversion de 1951 a 2024");
            System.out.println("[8] Vector de 50 elementos enteros");
            System.out.println("Selecciona el problema: ");
    }


    // Metodo para ejecutar el programa de la calculadora
    static void Calculadora(){
        Calculadora calc = new Calculadora(); // Instanciar la clase Calculadora para acceder a sus métodos
        calc.menuCalculadora(); // Llamar al método menuCalculadora para mostrar el menú
    }
    
    // Metodo para llenar un arreglo con las letras del abecedario (26 letras) abecedario en ingles para evitar la ñ
    static void Problema10(){
        /* 
         * Crea un arreglo de caracteres en el cual coloque cada una de las letras del abecedario, lo que
        hará el algoritmo, es solicitar al usuario N cantidad de números entre el 1 y el 27 (habrás de
        validar que el numero este en ese rango) e imprimir las letras correspondientes por número
        aceptado. Puntos: 1
         */

        Scanner k = new Scanner(System.in);
        int num = 0; // Número a buscar en el arreglo
        char[] abc = new char[27]; // Arreglo de 27 elementos para las letras del abecedario

        // Llenar el arreglo con las letras del abecedario
        for (int i = 0; i < abc.length; i++) {
            abc[i] = (char) (i + 65);
        }

        boolean validInput = false;
        while(!validInput){
            System.out.println("Ingresa un número entre 1 y 26: "); 
            try {
                num = k.nextInt(); // Leer número del usuario
                // Validar que el número esté en el rango 1-26
                if(num >= 1 && num <= 26){
                    validInput = true;
                }else{
                    System.out.println("Número fuera de rango, debe ser entre 1-26");
                }
            } catch (Exception e) {
                System.out.println("La entrada no es válida, debe ser un número entero");
                k.next(); // Limpiar el buffer del scanner
            }
        }
        
        // Mostrar la letra correspondiente al número ingresado
        System.out.println("La letra correspondiente al número " + num + " es: " + abc[num - 1]);
        
    }

    // Metodo para llamar al programa de histograma de datos aumentando los asteriscos
    static void Problema11(){
        /*
         * Realice un algoritmo que permita introducir un arreglo de n elementos, el programa mostrara
            un histograma de esos datos (el histograma se interpretara con la salida de n asteriscos donde n
            es el valor de cada elemento del arreglo) ej: el arreglo es 2,3,4 el histograma será 2->**3->***4-
            >**** Puntos: 1
         */

        Scanner k = new Scanner(System.in);
        int nNumeros = 0; // Número de elementos a introducir en el arreglo
        System.out.println("Ingresa el número de elementos a introducir en el arreglo: ");
        
        while (nNumeros <= 0) { // Validar que el número de elementos sea mayor a 0 y sea un número entero
            try {
                nNumeros = k.nextInt(); // Leer número de elementos del usuario
                if (nNumeros <= 0) {
                    System.out.println("El número de elementos debe ser mayor a 0");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un número entero");
                k.next(); // Limpiar el buffer del scanner
            }
        }

        int[] numeros = new int[nNumeros]; // Declarar arreglo de n elementos

        // Leer los n elementos del usuario
        for (int i = 0; i < nNumeros; i++) {
            System.out.println("Ingresa el número " + (i + 1) + ": ");
            numeros[i] = k.nextInt();
        }

        // Mostrar el histograma de los n elementos
        for (int i = 0; i < nNumeros; i++) {
            System.out.print(numeros[i] + "->");
            for (int j = 0; j < numeros[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Metodo para llamar al programa de invertir un arreglo de n elementos
    static void Problema12() {
        /*
         * 12. Se requiere un algoritmo que lea un vector de 8 elementos e intercambie las posiciones de sus
        elementos, de tal forma que el primer elemento pase a ser el último y el último el primero, el
        segundo el penúltimo y así sucesivamente, e imprima ese vector. Puntos: 1
         */
    
        Scanner k = new Scanner(System.in);
    
        int[] numeros = new int[8]; // Declarar arreglo de 8 elementos
    
        // Leer los 8 elementos del usuario
        for (int i = 0; i < 8; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.println("Ingresa el número " + (i + 1) + ": ");
                try {
                    numeros[i] = k.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
                    k.next(); // Limpiar el buffer del scanner
                }
            }
        }
    
        // Intercambiar las posiciones de los elementos
        for (int i = 0; i < 8 / 2; i++) {
            int temp = numeros[i];
            numeros[i] = numeros[8 - 1 - i];
            numeros[8 - 1 - i] = temp;
        }
    
        // Mostrar el vector con las posiciones intercambiadas
        System.out.println("Vector con posiciones intercambiadas:");
        for (int i = 0; i < 8; i++) {
            System.out.print(numeros[i] + " | ");
        }
        System.out.println();
    }

    // Metodo para llamar al programa de mostrar en orden inverso a como fueron introducidos
    static void Problema13(){
        /*
         * 13. Elabora un algoritmo que permita introducir n elementos de tipo entero en un arreglo, el
        programa mostrara impreso el arreglo en orden inverso a como fueron introducidos. Puntos: 2
         */
        Scanner k = new Scanner(System.in);
        int nNumeros = 0; // Número de elementos a introducir en el arreglo

        System.out.println("Ingresa el número de elementos a introducir en el arreglo: ");
        
        while (nNumeros <= 0) { // Validar que el número de elementos sea mayor a 0 y sea un número entero
            try {
                nNumeros = k.nextInt(); // Leer número de elementos del usuario
                if (nNumeros <= 0) {
                    System.out.println("El número de elementos debe ser mayor a 0");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un número entero");
                k.next(); // Limpiar el buffer del scanner
            }
        }

        int[] numeros = new int[nNumeros]; // Declarar arreglo de n elementos

        // Leer los n elementos del usuario
        for (int i = 0; i < nNumeros; i++) {
            System.out.println("Ingresa el número " + (i + 1) + ": ");
            numeros[i] = k.nextInt();
        }

        // Mostrar los n elementos en orden inverso
        System.out.println("Elementos en orden inverso: ");
        for (int i = nNumeros - 1; i >= 0; i--) {
            System.out.print(numeros[i] +" ");
        }
        System.out.println();
    }

    // Metodo para llamar al programa de vector de 50 elementos enteros
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
        limpiarConsola();

         System.out.println("Problema 17: Vector de 50 elementos enteros");
         System.out.println("Este programa hará lo siguiente: ");
         System.out.println("a. Leer un valor x y buscar en qué posición del vector se encuentra\r\n" + //
                          "b. Llene otro vector con los elementos de las posiciones impares del vector.\r\n" + //
                          "c. En este último vector, busque cuántos elementos son múltiplos de 3");

        // Sleep 2s
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Declaración de variables
        int vector[] = new int[50];
        int numX = 0; // Número a buscar en el vector
        int posX = -1; // Posición del número a buscar en el vector, inicializada a -1

        // Llenar vector con números enteros aleatorios entre 1-100
        // Mostrar el vector lleno
        for (int i = 0; i < vector.length; i++) {
            vector[i] = rnd.nextInt(100) + 1; // valores entre 1 y 100
            System.out.println("Posición " + i + ": " + vector[i]);
        }

        System.out.println("Ingresa el número a buscar en el vector de 50 números:");
        
        boolean validInput = false;
        while (!validInput) {
            try {
                numX = k.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Debes ingresar un número entero");
                k.next(); // Limpiar el buffer del scanner
            }
        }

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

    // Metodo para llamar al programa de la función exponencial de Taylor
    static void Problema5(){
        Scanner k = new Scanner(System.in);
        // 5. Implementa la función exponencial: Taylor
        
        // Declarar variables
        
        double resultado; // Variable para guardar el resultado
        double t = 1.0; // El primer termino es 1
        double suma = 1.0; // Variable para ir sumando los valores de la serie

        int x = 0;
        int n = 0; // Número de términos de la serie

        // Pedir valores al usuario
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Ingresa el valor de x: ");
                x = k.nextInt();
                System.out.println("Ingresa el número de términos de la sucesión: ");
                n = k.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Debes ingresar un número entero");
                k.next(); // Limpiar el buffer del scanner
            }
        }

        // Ciclo para realizar la serie
        for (int i = 1; i < n; i++) {
            t = t * x / i; // calcular termino de la sucesion
            suma += t; // Añade los terminos de la sucesion y los suma
        }
        resultado = suma;
        
        // Imprimir el resultado de la serie
        System.out.println("El valor aproximaodo de e^" + x + " es: " + resultado);
        
    }
    
    // Metodo para llamar al programa de la inversión de 1951 a 2024
    static void Problema7(){
        /* 7. En 1951, una persona vendió las tierras de su abuelo al gobierno por la cantidad de $1500.
        Suponga que esta persona ha colocado el dinero en una cuenta de ahorros que paga 15% anual.
        ¿Cuánto vale ahora su inversión? P(1+i)^n. */
        
        // Declarar variables
        double r; // Es el monto final
        double p = 1500; // Cantidad inicial de dinero
        double i = 0.15; // tasa de interés anual
        int n = 2024 - 1951; // cantidad de años

        // realizar calculo
        r = 1 + i; // realizar la operación que está dentro del parentesis: (1 + i) = (1 + 0.15)
        r = Math.pow(r, n); // Realizar exponente: (1.15)^73
        r = p * r; // realizar la multiplicación en este caso: 1500 * 26973.81

        // Imprimir resultado
        System.out.printf("El monto de la inversion en 2024 es: $%.2f\n", r);
    }

    // Metodo para limpiar la consola
    public static void limpiarConsola() {  
        System.out.print("\033[H\033[2J"); 
        System.out.flush();  
    } 

}





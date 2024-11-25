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
            System.out.println("[2] Letras del abecedario");
            System.out.println("[3] Histograma de datos");
            System.out.println("[4] Intercambiar posiciones de un arreglo");
            System.out.println("[5] Funcion exponencial: Taylor");
            System.out.println("[6] Invertir un arreglo de n elementos");
            System.out.println("[7] Valor de inversion de 1951 a 2024");
            System.out.println("[10] Vector de 50 elementos enteros");
            System.out.println("Selecciona el problema: ");

            seleccionPrograma = k.nextInt();

            switch (seleccionPrograma) {
                case 1:
                    // Ejecutar calculadora programa N1
                    Calculadora(); // 1 pto
                    break;
                case 2:
                    Problema10(); // 1 pto
                    break;
                case 3:
                    Problema11(); // 1 pto
                    break;
                case 4:
                    Problema12(); // 1 pto
                    break;
                case 5:
                    Problema5(); // 2 ptos
                    break;
                case 6:
                    Problema13(); // 2 ptos
                    break;
                case 7:
                    Problema7(); // 1 pto
                    break;
                case 10:
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


    // Metodo para ejecutar el programa de la calculadora
    static void Calculadora(){
        Calculadora calc = new Calculadora();
        calc.menuCalculadora();
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
        int num; // Número a buscar en el arreglo
        char[] abc = new char[27]; // Arreglo de 27 elementos para las letras del abecedario
        System.out.println("Ingresa un número entre 1 y 26: "); 
        num = k.nextInt(); // Leer número del usuario
        // Validar que el número esté en el rango 1-26
        if (num < 1 || num > 26) {
            System.out.println("Número fuera de rango, debe ser entre 1-26");
            return;
        }else{
            // Llenar el arreglo con las letras del abecedario
            for (int i = 0; i < abc.length; i++) {
                abc[i] = (char) (i + 65);
            }
            // Mostrar la letra correspondiente al número ingresado
            System.out.println("La letra correspondiente al número " + num + " es: " + abc[num - 1]);
        }
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
        int nNumeros; // Número de elementos a introducir en el arreglo
        System.out.println("Ingresa el número de elementos a introducir en el arreglo: ");
        nNumeros = k.nextInt(); // Leer número de y del usuario

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
    static void Problema12(){
        /*
         * 12. Se requiere un algoritmo que lea un vector de 8 elementos e intercambie las posiciones de sus
        elementos, de tal forma que el primer elemento pase a ser el último y el último el primero, el
        segundo el penúltimo y así sucesivamente, e imprima ese vector. Puntos: 1
         */

        Scanner k = new Scanner(System.in);
        int nNumeros; // Número de elementos a introducir en el arreglo
        System.out.println("Ingresa el número de elementos a introducir en el arreglo: ");
        nNumeros = k.nextInt(); // Leer número de elementos del usuario

        int[] numeros = new int[nNumeros]; // Declarar arreglo de n elementos

        // Leer los n elementos del usuario
        for (int i = 0; i < nNumeros; i++) {
            System.out.println("Ingresa el número " + (i + 1) + ": ");
            numeros[i] = k.nextInt();
        }

        // Intercambiar las posiciones de los elementos
        for (int i = 0; i < nNumeros / 2; i++) {
            int temp = numeros[i];
            numeros[i] = numeros[nNumeros - 1 - i];
            numeros[nNumeros - 1 - i] = temp;
        }

        // Mostrar el vector con las posiciones intercambiadas
        System.out.println("Vector con posiciones intercambiadas:");
        for (int i = 0; i < nNumeros; i++) {
            System.out.println(numeros[i]);
        }
    }

    // Metodo para llamar al programa de mostrar en orden inverso a como fueron introducidos
    static void Problema13(){
        /*
         * 13. Elabora un algoritmo que permita introducir n elementos de tipo entero en un arreglo, el
        programa mostrara impreso el arreglo en orden inverso a como fueron introducidos. Puntos: 2
         */
        Scanner k = new Scanner(System.in);
        int nNumeros; // Número de elementos a introducir en el arreglo
        System.out.println("Ingresa el número de elementos a introducir en el arreglo: ");
        nNumeros = k.nextInt(); // Leer número de elementos del usuario
        int[] numeros = new int[nNumeros]; // Declarar arreglo de n elementos
        // Leer los n elementos del usuario
        for (int i = 0; i < nNumeros; i++) {
            System.out.println("Ingresa el número " + (i + 1) + ": ");
            numeros[i] = k.nextInt();
        }
        // Mostrar los n elementos en orden inverso
        System.out.println("Elementos en orden inverso: ");
        for (int i = nNumeros - 1; i >= 0; i--) {
            System.out.println(numeros[i]);
        }
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

    // Metodo para llamar al programa de la función exponencial de Taylor
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
    
    // Metodo para llamar al programa de la inversión de 1951 a 2024
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

    // Metodo para limpiar la consola
    public static void limpiarConsola() {  
        System.out.print("\033[H\033[2J"); 
        System.out.flush();  
    } 

}





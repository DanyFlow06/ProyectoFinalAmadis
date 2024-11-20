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
            System.out.println("[10] Problema 23");
            System.out.println("Selecciona el problema: ");

            seleccionPrograma = k.nextInt();

            switch (seleccionPrograma) {
                case 1:
                    // Ejecutar calculadora programa N1
                    Calculadora();
                    break;
                case 2:
                    Problema2();
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
                System.out.println("¿Quieres seguir con el programa? [s/n] (s=si, n=no)");
                seleccionWhile = k.next().toLowerCase().charAt(0);
                continuarPrograma = (seleccionWhile == 's') ? true : false;
            } catch (Exception e) {
                System.out.println("Debes ingresar solo números (0-1)");
                break;
            }
        }

        
    }


    static void Calculadora(){
        /*
        Desarrolla una calculadora la cual habrá de hacer el cálculo de la suma, división, multiplicación y
        exponenciación a N cantidad para una N cantidad de números que el usuario desee. Puntos: 1 */
 
        // Declaracion de variables
        int asdasda; // Variable para guardar el resultado
        int variable2; // Variable para contador
        int asd3; // Variable para no sé que
        
        System.out.println("Hola desde Calculadora");
    }

    static void Problema2(){

        System.out.println("Hola desde Problema2");



        // TODO: Desarrolla el problema 2
    }

    static void Problema17() {
        Scanner k = new Scanner(System.in);
        Random rnd = new Random();

        /*
         * 17. Se necesita generar un vector de 50 elementos con valores numéricos enteros (imprima el
            vector lleno, el usuario no lo llena), realice lo siguiente:
            a. Leer un valor x y buscar en qué posición del vector se encuentra
            b. Llene otro vector con los elementos de las posiciones impares del vector.
            c. En este último vector, busque cuántos elementos son múltiplos de 3 Puntos: 1
         */

        // Declaracion de variables
        int vector[] = new int[50];
        int numX; // Número a buscar en el vector
        int posX; // Posición del número a buscar en el vector

        
        
        // Llenar vector con numeros enteros aleatorios entre 1-100
        // Mostrar el vector lleno
        for (int i = 0; i < vector.length; i++) {
            vector[i] = rnd.nextInt(1, 100);
            System.out.println("Posición " + i + ": " + vector[i]);
        }

        System.out.println("Ingresa el número a buscar en el vector de 50 números:");
        numX = k.nextInt();
        
        // Buscar el número en el vector
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == numX) {
                posX = i;
                System.out.println("El número " + numX + " se encuentra en la posición " + posX);
                break;
            }
        }

        // Llenar otro vector con los elementos de las posiciones impares del vector

    }

}



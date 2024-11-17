import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner k = new Scanner(System.in);

        boolean continuarPrograma = true;
        int seleccionWhile;
        int seleccionPrograma;
        while (continuarPrograma) {
            System.out.println("Bienvenido a nuestro programa");
            
            System.out.println("Lista de problemas.");
            System.out.println("[1] Calculadora");
            System.out.println("[2] Problema 2");
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

                // TODOS LOS CASOS ABAJO ->
            
                default:
                    break;
            }


            // Pregunta si continuar el programa
            try {
                System.out.println("¿Quieres seguir con el programa? [0-1] (0 = no y 1 = si)");
                seleccionWhile = k.nextInt();
                continuarPrograma = (seleccionWhile == 1) ? true : false;
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

}

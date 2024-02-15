import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Mostrar un menú de opciones
       int opcion=menu();



        // Realizar la operación seleccionada
        int resultado;
        if(opcion !=5){
            // Pedir al usuario la cantidad de números que quiere ooerar
            System.out.print("Ingrese la cantidad de números a operar: ");
            int cantidadNumeros = scanner.nextInt();

            // Validar la cantidad de números
            if (cantidadNumeros <= 0) {
                System.out.println("Error, La cantidad de números debe ser mayor a 0");
                return;
            }

            // Pedir al usuario los números
            int[] numeros = new int[cantidadNumeros];
            for (int i = 0; i < cantidadNumeros; i++) {
                System.out.print("Ingrese el número " + (i + 1) + ": ");
                numeros[i] = scanner.nextInt();
            }
            if(opcion==1){
                resultado=sumar(numeros);
                System.out.println("Resultado :"+resultado);
            }
            if(opcion==2){
                resultado=restar(numeros);
                System.out.println("Resultado :"+resultado);
            }
            if(opcion==3){
                resultado=multiplicar(numeros);
                System.out.println("Resultado :"+resultado);

            }
            if(opcion==4){
                resultado=dividir(numeros);
                System.out.println("Resultado :"+resultado);

            }



        }
        else{
            System.out.println("Sesion Finalizada");
            return;
        }



    }

    public static int menu(){
        Scanner input = new Scanner(System.in);
        String opString = ""; //Opción sin validar
        boolean bueno = false;
        int opcion = 0; //opcion para validar

        while (!bueno){
            System.out.println("--------------------------------");
            System.out.println("Menú");
            System.out.println("\nElija la operación que desea realizar:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");
            opString = input.nextLine();
            try{
                opcion = Integer.parseInt(opString);
                if (opcion<1 || opcion>5) //Debe ser una opción válida
                    System.out.println("Debe ingresar una de las opciones del menú");
                else
                    bueno = true;
            }
            catch(Exception e){
                System.out.println("Debe ingresar un número entero\n");
            }
        }
        return opcion;
    }


    private static int sumar(int[] numeros) {
        int suma = 0;
        for (int numero : numeros) {
            suma += numero;
        }
        return suma;
    }

    private static int restar(int[] numeros) {
        int resta = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            resta -= numeros[i];
        }
        return resta;
    }

    private static int multiplicar(int[] numeros) {
        int producto = 1;
        for (int numero : numeros) {
            producto *= numero;
        }
        return producto;
    }

    private static int dividir(int[] numeros) throws ArithmeticException {
        if (numeros.length != 2) {
            throw new ArithmeticException("No se puede dividir con un solo número, o solo puedes divir un numero dentro de otro");
        }


        int division = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] == 0) {
                throw new ArithmeticException("División por cero");
            }
            division /= numeros[i];
        }
        return division;
    }
}


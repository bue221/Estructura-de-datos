import java.util.Scanner;

public class Arrays {

    public static void imprimirArray(int[] array, char x) {
        if (x == 'A') {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        } else if (x == 'D') {
            for (int i = array.length - 1; i >= 0; i--) {
                System.out.print(array[i] + " ");
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Selecione la longitud del array: ");
        int value = sc.nextInt();

        int arrayNuevo[] = new int[value];

        for (int i = 0; i < arrayNuevo.length; i++) {
            int numero = (int) (Math.random() * 50 + 1);
            arrayNuevo[i] = numero * i;
        }

        int comp = 0;
        long startTime = System.currentTimeMillis();
        for (int j = 0; j < arrayNuevo.length - 1; j++) {
            for (int i = 0; i < arrayNuevo.length - 1; i++) {
                if (arrayNuevo[i] > arrayNuevo[i + 1]) {
                    int temp = arrayNuevo[i];
                    arrayNuevo[i] = arrayNuevo[i + 1];
                    arrayNuevo[i + 1] = temp;
                }
            }
            // System.out.print("Paso "+ j +": ");
            // imprimirArray(arrayNuevo, 'A');
            // System.out.println(" ");
            comp += 1;
        }
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Numero de comparaciones: " + comp);
        System.out.println("Tiempo de ejecucion es de: " + endTime + " milesegundos");
        System.out.println(" ");


        System.out.println("---------------------------Array ordenado menor a mayor-----------------------------");
        imprimirArray(arrayNuevo, 'A');
        System.out.println(" ");
        System.out.println("---------------------------Array ordenado mayor a menor-----------------------------");
        imprimirArray(arrayNuevo, 'D');

    }
}
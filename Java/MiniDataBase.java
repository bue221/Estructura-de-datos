
import java.util.Scanner;
import java.util.Arrays;

public class MiniDataBase {
    /* Metodos del programa */

    public static void imprimir(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " , ");
        }
    }

    public int busqueda(String[] array, String valor) {
        // boolean encontrado = false;
        int posicion = -1;
        for (int i = 0; i < array.length; i++) {
            String temp = array[i];
            if (temp.equals(valor)) {
                // encontrado = true;
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public static void main(String[] args) {

        // scanner
        Scanner sc = new Scanner(System.in);
        // instancia del objeto para llamar a metodo busqueda
        MiniDataBase min = new MiniDataBase();

        System.out.println("Selecione la longitud del array de letras: ");
        int value = sc.nextInt();

        // Array
        String arrayNuevo[] = new String[value];

        /* llenado automatico */
        // for (int i = 0; i < arrayNuevo.length; i++) {
        // int codigoAscii = (int) Math.floor(Math.random() * (122 - 97) + 97);
        // arrayNuevo[i] = (char) codigoAscii + "";
        // }

        int opcion = 0;
        do {
            /* Limpiar lineas */
            System.out.println("-----------------------------------------------------");
            // System.out.flush();
            /* Impresiones de opciones */
            System.out.println("Menu");
            System.out.println("1. Insertar");
            System.out.println("2. Buscar");
            System.out.println("3. Modificar");
            System.out.println("4. Eliminar");
            System.out.println("5. Imprimir todo el array");
            System.out.println("6. Salir del programa");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    /* Bucle para rellenar el array con números introducidos por teclado */
                    for (int i = 0; i < arrayNuevo.length; i++) {
                        System.out.print("Introduzca número para el elemento " + (i + 1) + ": ");
                        arrayNuevo[i] = sc.next();
                    }
                    Arrays.sort(arrayNuevo);
                    break;
                case 2:
                    // Busqueda
                    System.out.print("Ingrese el valor de elemento a buscar: ");
                    String valor = sc.next();
                    int encontrado = min.busqueda(arrayNuevo, valor);
                    if (encontrado != -1) {
                        System.out.println("El valor " + valor + " se encuentra en la posicion: " + (encontrado + 1));
                    } else {
                        System.out.println("No se encontro el valor: " + valor);
                    }
                    // se ordena el array
                    Arrays.sort(arrayNuevo);
                    break;
                case 3:
                    // Modificar
                    System.out.print("Digite valor que desea modificar: ");
                    String valorM = sc.next();

                    int buscaqueda_Modificar = min.busqueda(arrayNuevo, valorM);

                    if (buscaqueda_Modificar == -1) {
                        System.out.println("No se encontro el valor: " + valorM);
                        break;
                    } else {
                        System.out.print("Ingrese el valor que desea colocar: ");
                        String word = sc.next();
                        int buscar_word = min.busqueda(arrayNuevo, word);
                        if (buscar_word == -1) {
                            arrayNuevo[buscaqueda_Modificar] = word;
                        } else {
                            System.out.println("Ese valor ya existe en el array");
                            break;
                        }
                    }
                    // se ordena el array
                    Arrays.sort(arrayNuevo);
                    break;
                case 4:
                    // Eliminar
                    System.out.print("Digite valor que desea Eliminar: ");
                    String valorL = sc.next();
                    int buscar_Eliminar = min.busqueda(arrayNuevo, valorL);
                    if (buscar_Eliminar == -1) {
                        System.out.println("No se encontro el valor: " + valorL);
                        break;
                    } else {
                        arrayNuevo[buscar_Eliminar] = "";
                    }
                    // se ordena el array
                    Arrays.sort(arrayNuevo);
                    break;
                case 5:
                    // se ordena el array
                    Arrays.sort(arrayNuevo);

                    System.out.print("[");
                    imprimir(arrayNuevo);
                    System.out.print("]");
                    System.out.println(" ");
                    break;
                case 6:
                    System.exit(0);
                default:
                    break;
            }
        } while (opcion != 0);

    }
}

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	
	int tamanoDeModelosDeEstanteria[3][2] = {
        {1000,8000},
        {8000,6000},
        {4000,6000}
    };
    /* Donde la posicion 0 representa el tipo A y asi sucesivamente
    tipo A
    tamanoDeModelosDeEstanteria[0][0] = 1000; es decir esto representaria el numero de modelos de tipo A de tamaño Grande
    tamanoDeModelosDeEstanteria[0][1] = 8000; Pequeño
    tipo B 
    tamanoDeModelosDeEstanteria[1][0] = 8000; Grande
    tamanoDeModelosDeEstanteria[1][1] = 6000;  Pequeño
    tipo C 
    tamanoDeModelosDeEstanteria[2][0] = 4000; Grande
    tamanoDeModelosDeEstanteria[2][1] = 6000;  Pequeño */ 

    int cantidadDeTornillosYSoportesPorTamano[2][2]= {
        {16, 6},
        {12, 4}
    };

    /*Grande - Tornillos
    cantidadDeTornillosYSoportesPorTamano[0][0] = 16;
    Grande - Soportes
    cantidadDeTornillosYSoportesPorTamano[0][1] = 6;
    Pequeño - Tornillos
    cantidadDeTornillosYSoportesPorTamano[1][0] = 12;
    Pequeño - Soportes
    cantidadDeTornillosYSoportesPorTamano[1][1] = 4;*/

    /* Esta sera el calculo de la cantidad de soportes y 
    tornillos que necesita cada tipo segun su cantidad 
    de modelos y su tamaño*/

    int matrizFinal[2][3];

    // Esta operacion esta definida por el producto matricial
    /*El resultado de la multiplicación A⋅B
    es la suma del primer elemento de A
    por el primero de B
    más el segundo elemento de A por el segundo de B más el tercer 
    elemento de A por el tercero de  B*/
    for (int a = 0; a < 2; a++) {
        for (int i = 0; i < 3; i++) {
            int suma = 0;
            for (int j = 0; j < 2; j++) {
                suma += tamanoDeModelosDeEstanteria[i][j] * cantidadDeTornillosYSoportesPorTamano[j][a];
            }
            matrizFinal[i][a] = suma;
        }
    }

    printf("\nMatriz de cantidad de tornillos y soportes por tipo \n\n");
    printf("       Tornillos - Soportes\n");
    for (int i = 0; i < 3; i++) {
        if(i== 0){
            printf("Tipo A: ");
        }
        if(i== 1){
            printf("Tipo B: ");
        }
        if(i== 2){
            printf("Tipo C: ");
        }
        for (int j = 0; j < 2; j++) {
            printf("%d ", matrizFinal[i][j]);
        }
        printf("\n");
    }

    return 0;
}
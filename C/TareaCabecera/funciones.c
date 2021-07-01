#include <stdlib.h>
#include <stdio.h>
//se llama al archivo cabecera
// el cual contiene los prototipos y estructuras
#include "funciones.h"

//variables a usar
int respuesta, ii;

/*Primera función*/
void cargar(int max, Persona *punt)
{
    int ii;
    /*Ciclo para cargar datos*/
    for (ii = 0; ii < max; ii++)
    {
        printf("Ingrese los datos para la %da persona.\n ", ii + 1);
        printf("Ingrese la Edad: \t");
        scanf("%d", &(*(punt + ii)).edad);
        printf("\n Ingrese Nombre: \t");
        fflush(stdin);
        scanf("%s", &punt[ii].nombre);
        printf("\n Ingrese la Matricula: \t");
        scanf("%d", &punt[ii].matricula);
    } /*Fin del ciclo*/
}

//segunda funcion
void desplegar(int max, Persona *punt)
{
    int ii;
    /*Ciclo para imprimir*/
    for (ii = 0; ii < max; ii++)
    {
        printf("\n Datos de la %da persona: ", ii + 1);
        printf("Edad %3d ", (*(punt + ii)).edad);
        printf(" Nombre %10s ", (*(punt + ii)).nombre);
        printf(" Matricula %5d\n", (*(punt + ii)).matricula);
    } /*Fin del ciclo*/
}
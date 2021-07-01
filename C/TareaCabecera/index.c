#include <stdlib.h>
#include <stdio.h>
//se llama al archivo cabecera
// el cual contiene los prototipos y estructuras
#include "funciones.h"

// constante
#define MAX 3

int main()
{
    /*Definicion del vector alumnos de tipo Persona*/
    Persona alumnos[MAX];

    /*Llamada a funciones*/
    cargar(MAX, alumnos);
    desplegar(MAX, alumnos);
    printf("\n\n\n");
    system("pause");

    return (0);
}


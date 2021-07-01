#include <stdio.h>
#include <stdlib.h>

#define TAM 10

// struct 
struct jugador
{
    char nombre[40];
    float estatura;
    int edad;
};

int main(int argc, char *argv[])
{
    // array de tipo struct jugador
    struct jugador j[TAM];

    int i;
    //ingreso de datos al struct
    for (i = 0; i < TAM; i++)
    {
        printf("\nNombre del jugador: ");
        fflush(stdin);
        gets(j[i].nombre);
        printf("\nEstatura del jugador: ");
        scanf("%f", &j[i].estatura);
        printf("\nEdad del jugador: ");
        scanf("%d", &j[i].edad);
    }

    // menu
    printf("Menu:\n");
    printf("[ 1 ] Listar nombres\n");
    printf("[ 2 ] Listar estaturas\n");
    printf("[ 3 ] Listar edades\n");

    int selec;
    scanf("%d", &selec);
    // switch que decide que va a suceder
    switch (selec)
    {
    case 1:
        printf("[");
        for (int i = 0; i < TAM; i++)
        {
            printf("%s, ", j[i].nombre);
        }
        printf("]");
        break;
    case 2:
        printf("[");
        for (int i = 0; i < TAM; i++)
        {
            printf("%f ", j[i].estatura);
        }
        printf("]");
        break;
    case 3:
        printf("[");
        for (int i = 0; i < TAM; i++)
        {
            printf("%i ", j[i].estatura);
        }
        printf("]");
        break;
    default:
        printf("Esa opcion no existe");
        break;
    }
}
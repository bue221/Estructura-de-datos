#include <stdio.h>
#include <stdlib.h>
// struct
struct jugador
{
    char nombre[40];
    float estatura;
    int edad;
};

int main(int argc, char *argv[])
{
    //declaracion de una variable de tipo struct
    struct jugador j;
    //ingreso de datos
    printf("Nombre del jugador: ");
    gets(j.nombre);
    printf("Estatura del jugador: ");
    scanf("%f", &j.estatura);
    printf("Edad del jugador: ");
    scanf("%d", &j.edad);
    // menu para selecionar bque se va realizar
    printf("Menu:\n");
    printf("[ 1 ] Listar nombre\n");
    printf("[ 2 ] Listar estatura\n");
    printf("[ 3 ] Listar edad\n");

    int selec;
    scanf("%d", &selec);

    // swicth que controla que sucede
    switch (selec)
    {
    case 1:
        printf(j.nombre);
        break;
    case 2:
        printf("%f", j.estatura);
        break;
    case 3:
        printf("%i", j.edad);
        break;
    default:
        printf("Esa opcion no existe");
        break;
    }
}
/*La información de todos los empleados de la empresa EstructSystem está almacenada en
una variable de tipo struct llamada “empleado”. La información con que se cuenta de cada
empleado es: Nombre, sexo y sueldo. Por lo tanto, se pide elaborar un programa en
lenguaje c que lea en un array de estructuras los datos de los N trabajadores de la empresa
y que imprima los datos del empleado con mayor y menor salario*/

#include <stdio.h>
#include <stdlib.h>
// constante
#define NUMEMPL 4

// struct
struct empleado {
    char nombre[40];
    char sexo[10];
    int sueldo;
};

// declaracion del struct
typedef struct empleado Empleado;

// Prototipos de funciones
void ingresar(int max, Empleado *punt);
void listarDatos(int max, Empleado *punt);
void mayor(int max, Empleado *punt);
void menor(int max, Empleado *punt);

int main(int argc, char *argv[]){
    
    Empleado EstructSystem[NUMEMPL];
    // ingreso de datos al array EstructSystem
    ingresar(NUMEMPL, EstructSystem);

    int select = -1;

    while (select != 0)
    {
        //impresion del menu
        printf("Menu:\n");
        printf("[ 1 ] Listar datos\n");
        printf("[ 2 ] Buscar mayor sueldo\n");
        printf("[ 3 ] Buscar menor sueldo\n");
        printf("[ 0 ] Salir\n");
        // se pide el valor de select
        scanf("%d", &select);
        // switch que maneja que se va a realizar
        switch (select)
        {
        case 1:
            listarDatos(NUMEMPL,EstructSystem);
            break;
        case 2:
            mayor(NUMEMPL,EstructSystem);
            break;
        case 3:
            menor(NUMEMPL,EstructSystem);
            break;
        default:
            break;
        }

    }
    
}
// variable a usar
int ii;
// funcion para el ingreso de datos
void ingresar(int max, Empleado *punt) {
    for(ii = 0;ii<max; ii++){
        printf("Ingrese los datos para el %d empleado.\n ", ii + 1);
        printf("Ingrese Nombre: \t");
        fflush(stdin);
        scanf("%s", &punt[ii].nombre);
        printf("Ingrese el sexo: \t");
        fflush(stdin);
        scanf("%s", &punt[ii].sexo);
        printf("Ingrese el sueldo: \t");
        scanf("%d", &punt[ii].sueldo);
    }
}

// funcion para listar datos
void listarDatos(int max, Empleado *punt)
{
    int ii;
    for (ii = 0; ii < max; ii++)
    {
        printf("\n Datos del %d empleado: \n", ii + 1);
        printf(" Nombre %10s \n", (*(punt + ii)).nombre);
        printf(" Sexo %s\n", (*(punt + ii)).sexo);
        printf("Sueldo %d \n", (*(punt + ii)).sueldo);
    }
}

// funcion para saber el empleado con mas sueldo
void mayor(int max, Empleado *punt){
    int mayor = punt[0].sueldo, posMayor = 0;
    for(ii=0;ii<max;ii++){
        if(punt[ii].sueldo > mayor){
            mayor = punt[ii].sueldo;
            posMayor = ii;
        }
    }
    printf("\n El empleado %s tiene el mayor sueldo: %d\n",punt[posMayor].nombre,punt[posMayor].sueldo);
}

// funcion para saber el empleado con menos sueldo
void menor(int max, Empleado *punt){
    int menor = punt[0].sueldo, posMenor = 0;
    for(ii=0;ii<max;ii++){
        if(punt[ii].sueldo < menor){
            menor = punt[ii].sueldo;
            posMenor = ii;
        }
    }
    printf("\n El empleado %s tiene el menor sueldo: %d\n",punt[posMenor].nombre,punt[posMenor].sueldo);
}
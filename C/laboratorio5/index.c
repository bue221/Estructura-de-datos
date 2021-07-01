/*De acuerdo con las siguientes declaraciones de estructuras elabore un programa en 
lenguaje c que lea el array ats y devuelva los datos (nombre, pais, deporte) del atleta que 
ha ganado el mayor n�mero de medallas.*/

#include <stdlib.h>
#include <stdio.h>

#define MAX 3

struct datos{
    char nombre[30];
    char pais[25];
};

struct atleta{
    char deporte[30];
    struct datos pers;
    int medallas;
};

//Declaracion de structs
typedef struct datos Datos;
typedef struct atleta Ats;


//Prototipado de funciones
void ingresar(int max, Ats *punt);
void listar(int max, Ats *punt);
void verMayor(int max, Ats *punt);//metodo para ver la cantidad mayor de medallas

int main(int argc, char *argv[]){
    
    Ats Atleta[MAX];
    ingresar(MAX, Atleta);
    
    int select = -1;

    while (select != 0)
    {
        //impresion del menu
        printf("Menu:\n");
        printf("[ 1 ] Listar datos\n" );
        printf("[ 2 ] Buscar deportista con mas medallas\n");
        printf("[ 3 ] Salir\n");
        // se pide el valor de select
        scanf("%d", &select);
        // switch que maneja que se va a realizar
        switch (select)
        {
        case 1:
            listar(MAX,Atleta);
            break;
        case 2:
            verMayor(MAX,Atleta);
            break; 
		default:
            break;    
		}
    }
}
	int ii;
void ingresar(int max, Ats *punt) {
    for(ii = 0;ii<max; ii++){
        printf("Ingrese los datos para el %d atleta.\n ", ii + 1);
        
        printf("Ingrese Nombre: \t");
    	fflush(stdin);
    	scanf("%s", &punt[ii].pers.nombre);
    	
		printf("Ingrese Pais: \t");
        fflush(stdin);
    	scanf("%s", &punt[ii].pers.pais);
    	
		printf("Ingrese Deporte: \t");
        fflush(stdin);
        scanf("%s", &punt[ii].deporte);
        
        printf("Ingrese la cantidad de medallas: \t");
        fflush(stdin);
        scanf("%d", &punt[ii].medallas); 
    	
    	
    	printf("----------------------------------- \n ");
	}
}

// funcion para listar datos
void listar(int max, Ats *punt)    //Revisar datos 
{
    int ii;
    for (ii = 0; ii < max; ii++)
    {
        printf("\n Datos del %d deportista: \n", ii + 1);
        printf(" Nombre %10s \n", punt[ii].pers.nombre );
    	printf(" Pais %s\n", (*(punt + ii)).pers.pais);
    	printf("Deporte %s \n", (*(punt + ii)).deporte);
    	printf("Medallas %d \n", (*(punt + ii)).medallas);
    	printf("----------------------------------- \n");
	}
}

// funcion para saber el deporte con mas medallas
void verMayor(int max, Ats *punt){
    int mayor = punt[0].medallas, posMayor = 0;
    for(ii=0;ii<max;ii++){
        if(punt[ii].medallas > mayor){
            mayor = punt[ii].medallas;
            posMayor = ii;
        }
    }
    printf("\n El deportista %s tiene mas medallas: %d\n",punt[posMayor].pers.nombre,punt[posMayor].medallas);
}

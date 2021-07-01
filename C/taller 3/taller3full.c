#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct LibroBiblioteca
 {
  char *nombrelibro;
  struct LibroBiblioteca *siguiente;
 } Libro;

typedef struct BibliotecaIdentificar
 {
  Libro *inicio;
  Libro *fin;
  int tamano;
 } Biblioteca;

// INICIALIZACION DE LAS FUNCIONES
void inicializacion (Biblioteca *biblioteca);
int insertar_listavacia(Biblioteca *biblioteca, char *nombrelibro);
int insertar_inicio(Biblioteca *biblioteca, char *nombrelibro);
int insertar_final(Biblioteca *biblioteca, Libro * actual, char *nombrelibro);
int borrar_inicio(Biblioteca *biblioteca);

int menu (Biblioteca *biblioteca, int *k);
void muestra (Biblioteca *biblioteca);


int main(){
    char opcion;
    char *nom;
    Biblioteca *biblioteca;
    Libro *actual;

    if ((biblioteca = (Biblioteca *) malloc (sizeof (Biblioteca))) == NULL)
    return -1;
    if ((nom = (char *) malloc (50)) == NULL)
    return -1;
    actual = NULL;
    opcion = 'o';

    inicializacion (biblioteca);
    int pos, k;

    while (opcion!= 7)
    {
        opcion = menu (biblioteca, &k);
        switch (opcion)
        {
          case 1:
            printf ("Ingrese el nombre de un libro: ");
            scanf ("%s", nom);
            //getchar ();
            if (biblioteca->tamano == 0)
            insertar_listavacia (biblioteca, nom);
            else
            insertar_inicio (biblioteca, nom);
            printf ("\n%d libros: libro del inicio = %s, libro del final = %s\n", biblioteca->tamano,
                  biblioteca->inicio->nombrelibro, biblioteca->fin->nombrelibro);
            muestra (biblioteca);
          break;
          case 2:
            printf ("Ingrese el nombre de un libro: ");
            scanf ("%s", nom);
            //getchar ();
            insertar_final (biblioteca, biblioteca->fin, nom);
            printf ("\n%d libros: libro del inicio = %s, libro del final = %s\n", biblioteca->tamano,
            biblioteca->inicio->nombrelibro, biblioteca->fin->nombrelibro);
            muestra (biblioteca);
          break;
          case 3:
          borrar_inicio (biblioteca);
          if (biblioteca->tamano != 0)
            printf ("\n%d libros: libro del inicio = %s, libro del final = %s\n", biblioteca->tamano,
                    biblioteca->inicio->nombrelibro, biblioteca->fin->nombrelibro);
          else
            printf ("lista vacia\n");
          muestra (biblioteca);
          break;
          case 4:
          muestra (biblioteca);
          break;
          
        }   
    }
    return 0;
}

//-----------MENU----------------
int menu (Biblioteca *biblioteca, int *k)
 {
  int opcion;
  printf("-----MENU-----\n");
  if (biblioteca ->tamano == 0)
  {
    printf ("1. Inserte un libro\n");
    printf ("2. Salir del programa \n");
   }
  else
  {
    printf ("1. Insertar libro al inicio de la lista\n");
    printf ("2. Insertar libro al final de la lista\n");
    printf("3. Borrar libro al inicio de la lista\n");
    printf("4. Mostrar libros de la biblioteca");
  }
 printf ("\n\nElegir: ");
 scanf ("%d", &opcion);

 }
 
//-----------Funciones-----------------

//FUNCION PARA INICIALIZAR LA LISTA
void inicializacion (Biblioteca *biblioteca)
 {
  biblioteca->inicio = NULL;
  biblioteca->fin = NULL;
  biblioteca->tamano = 0;
 }

//FUNCION PARA INSERTAR EN LISTA VACIA
int insertar_listavacia (Biblioteca *biblioteca, char *nombrelibro)
 {
  Libro *nuevo_libro;
  if ((nuevo_libro = (Libro *) malloc (sizeof (Libro))) == NULL)
    return -1;
  if ((nuevo_libro->nombrelibro = (char *) malloc (50 * sizeof (char)))
      == NULL)
    return -1;
  strcpy (nuevo_libro->nombrelibro, nombrelibro);

  nuevo_libro->siguiente = NULL;
  biblioteca ->inicio = nuevo_libro;
  biblioteca ->fin = nuevo_libro;
  biblioteca ->tamano++;
  return 0;
 }

 //FUNCION PARA INSERTAR AL INICIO DE LA LISTA
int insertar_inicio(Biblioteca *biblioteca, char *nombrelibro)
 {
  Libro *nuevo_libro;
  if ((nuevo_libro = (Libro *) malloc (sizeof (Libro))) == NULL)
    return -1;
  if ((nuevo_libro->nombrelibro = (char *) malloc (50 * sizeof (char)))
      == NULL)
    return -1;
  strcpy (nuevo_libro->nombrelibro, nombrelibro);

  nuevo_libro->siguiente = biblioteca->inicio;
  biblioteca ->inicio = nuevo_libro;
  biblioteca ->tamano++;
  return 0;
 }

//FUNCION PARA INSERTAR AL FINAL DE LA LISTA
int insertar_final (Biblioteca *biblioteca, Libro *actual, char *nombrelibro)
 {
  Libro *nuevo_libro;
  if ((nuevo_libro = (Libro *) malloc (sizeof (Libro))) == NULL)
    return -1;
  if ((nuevo_libro->nombrelibro = (char *) malloc (50 * sizeof (char)))
      == NULL)
    return -1;
  strcpy (nuevo_libro->nombrelibro, nombrelibro);

  actual->siguiente = nuevo_libro;
  nuevo_libro->siguiente = NULL;

  biblioteca ->fin = nuevo_libro;

  biblioteca ->tamano++;
  return 0;
 }

 //FUNCION PARA BORRAR AL INICIO DE LA LISTA
 int borrar_inicio (Biblioteca *biblioteca)
 {
  if (biblioteca ->tamano == 0)
    return -1;
  Libro *borrar_libro;
  borrar_libro = biblioteca ->inicio;
  biblioteca ->inicio = biblioteca ->inicio->siguiente;
  if (biblioteca ->tamano == 1)
    biblioteca ->fin = NULL;
  free (borrar_libro->nombrelibro);
  free (borrar_libro);
  biblioteca ->tamano--;
  return 0;
 }

 //FUNCION PARA MOSTRAR LA LISTA
 void muestra (Biblioteca *biblioteca)
 {
  Libro *actual;
  actual = biblioteca ->inicio;
  int indice = 0;
  while (actual != NULL)
   {
      indice = indice + 1;
      printf ("\nLibro %d de la biblioteca: %s\n\n", indice, actual->nombrelibro);
      actual = actual->siguiente;
   }
 }

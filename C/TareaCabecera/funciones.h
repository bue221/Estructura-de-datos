// struct persona prototipo
struct persona
{
    int edad;
    char nombre[20];
    int matricula;
};

/*Se utiliza la clausura tipedef para definir Persona*/
typedef struct persona Persona;

/*Prototipo de funciones para cargar y desplegar datos*/
// esta permite realizar la importacion en el archivo principal
void cargar(int max, Persona *punt);
void desplegar(int max, Persona *punt);
package main

import (
	"./Estructura"
	"./Persona"
)

func main(){
	var cli *Persona.Cliente = Persona.New_Client(10101,"Andres",18);

	var lista *Estructura.Lista = Estructura.New_Lista();

	Estructura.Insertar(cli,lista);
	
	Estructura.Imprimir(lista);

	// fmt.Println("Hola mundo")
}
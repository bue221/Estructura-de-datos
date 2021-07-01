package Persona

type Cliente struct {
	Id     int
	Nombre string
	Edad   int
}

func New_Client(Id int, Nombre string, Edad int) *Cliente {
	return &Cliente{Id, Nombre, Edad}
}
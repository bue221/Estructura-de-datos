// vendria ha ser la estructura libro
class Libro {
  constructor(nombre, isbn) {
    this.nombre = nombre;
    this.isbn = isbn;
  }
}
// estructura nodo
class Nodo {
  constructor(nombre, isbn) {
    this.libro = new Libro(nombre, isbn);
    this.next = null;
  }
}
// estructura lista
class Lista {
  constructor() {
    this.cabeza = null;
    this.cola = null;
    this.tam = 0;
  }

  //metodo insertar
  add(nombre, isbn) {
    var nodo = new Nodo(nombre, isbn);
    //si esta vacia el nodo se vuelve cabeza y cola
    if (this.cabeza === null) {
      this.cabeza = nodo;
      this.cola = nodo;
      this.tam += 1;
      //si esta con uno o mas elementos el nodo se va a la cola
    } else {
      this.cola.next = nodo;
      this.cola = this.cola.next;
      this.tam += 1;
    }
  }

  //eliminar cabeza
  deleteHead() {
    if (this.cabeza !== null) {
      if (this.cabeza.next) {
        var secondNode = this.cabeza.next;
        this.cabeza = secondNode;
        this.tam -= 1;
      } else {
        this.cabeza = null;
        this.tam -= 1;
      }
    }
  }

  //metodo buscar
  find(value) {
    if (!this.cabeza) {
      return null;
    }
    let nodo = this.cabeza;

    while (nodo != null) {
      if (nodo.libro.nombre === value) {
        return nodo;
      }
      nodo = nodo.next;
    }
  }

  // se imprimime la lista
  print() {
    let currentNode = this.cabeza;
    console.log(
      "la cabeza es: ",
      this.cabeza.libro.nombre,
      "la cola es: ",
      this.cola.libro.nombre,
      "el tamano de la lista es: ",
      this.tam,
      "\n"
    );
    while (currentNode) {
      console.log(
        "Nombre del libro: ",
        currentNode.libro.nombre,
        ",Isbn del libro: ",
        currentNode.libro.isbn
      );
      currentNode = currentNode.next;
    }
  }
}

var eleccion;
const lista = new Lista();

lista.add("libro 2", "asas");
lista.add("libro 1", "asas");

lista.print();
lista.find("libro 1");
lista.deleteHead();
lista.print();

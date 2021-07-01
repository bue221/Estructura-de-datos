# Creamos la clase Libro
class Libro:
    def __init__(self,isbn,name):
        self.isbn = isbn
        self.name = name

# Creamos la clase Nodo
class Nodo:
    def __init__(self, name, isbn, next = None):
        self.data = Libro(isbn,name)
        self.next = next

# Creamos la clase Lista
class Lista: 
    def __init__(self):
        self.head = None
        self.tail = None
        self.tam = 0
    
    # Método para agregar nodos
    def addNodo(self, isbn,name):
        nodo = Nodo(isbn=isbn, name=name)
        if(self.head == None):
            self.head = nodo
            self.tail = nodo
            self.tam += 1
            return
        self.tail.next = nodo
        self.tail = self.tail.next
        self.tam += 1
    
    # Método para eleminar nodos
    def deleteNodo(self, key):
        curr = self.head
        prev = None
        while curr and curr.data.isbn != key:
            prev = curr
            curr = curr.next
        if prev is None:
            self.head = curr.next
            self.tam -= 1
        elif curr:
            prev.next = curr.next
            curr.next = None
            self.tam -= 1

    # Método para imprimir la lista de nodos
    def print_list( self ):
        node = self.head
        if(node != None):
            print(f'cabeza: {node.data.name} cola: {self.tail.data.name} tam: {self.tam}')
        else:
            print('La lista esta vacia')
        while node != None:
            if(node != None):
                print(f' title: {node.data.name} isbn: {node.data.isbn} ', end =" => ")
            node = node.next

    def findNodo(self, value):
        if(self.head == None):
            print('No existe')
            return
        nodo = self.head
        while(nodo):
            if (nodo.data.name == value):
                print(f'nombre: {nodo.data.name} isbn: {nodo.data.isbn}')
            nodo = nodo.next


s = Lista() # Instancia de la clase Lista

num=-1

while(num != 0):
    print("""
        Menu:
        [0] Salir
        [1] insertar libro
        [2] Eliminar Cabeza
        [3] imprimir Lista de libros
        [4] Buscar libro
    """)

    num = int(input("elegir: "))
    lista = Lista()

    if(num == 1):
        name = input('Inserte el nombre del libro: ')
        isbn = input('Inserte el isbn del libro: ')
        s.addNodo(isbn=isbn,name=name) # Agregamos un elemento al frente del nodo
    elif(num == 2):
        s.deleteNodo(input('Ingrese el isbn del libro a eliminar: '))
    elif(num == 3):
        s.print_list()
    elif(num == 4):
        s.findNodo(input('Ingrese el nombre del libro a buscar: '))


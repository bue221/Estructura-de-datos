public class Pila extends ListaEnlazada {

    Pila() {
        super();
    }

    public void push(String value) {
        Nodo nuevo = new Nodo();
        nuevo.setInformacion(value);
        if (this.ListaVacia()) {
            this.setInicioLista(nuevo);
        } else {
            nuevo.setSiguiente(this.getInicioLista());
            this.setInicioLista(nuevo);
        }
        this.setTamano(this.getTamano() + 1);
    }

    public String pop() {
        if (!this.ListaVacia()) {
            Nodo aux = this.getInicioLista();
            this.setInicioLista(this.getInicioLista().getSiguiente());
            this.setTamano(this.getTamano() - 1);
            return aux.getInformacion();
        }
        return null;
    }

    public void imprimir() {
        Nodo reco = this.getInicioLista();
        System.out.println("Listado de todos los elementos de la pila.");
        while (reco != null) {
            System.out.print(reco.getInformacion() + "-");
            reco = reco.getSiguiente();
        }
        System.out.println();
    }

    public String peek() {
        if (!ListaVacia()) {
            return this.getInicioLista().getInformacion();
        }
        return null;
    }

}

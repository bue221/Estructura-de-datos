import javax.swing.*;

public class ListaEnlazada {

    private Nodo inicioLista, finLista;
    private int tamano;

    String Lista = "";

    public ListaEnlazada() {
        this.inicioLista = null;
        this.finLista = null;
        this.tamano = 0;

    }

    // Revisar si la lista esta vacia
    public boolean ListaVacia() {
        return this.inicioLista == null;
    }

    // Limpia los procesos
    public void Limpiar() {
        this.inicioLista = null;
        this.finLista = null;
        this.tamano = 0;
    }

    // Mostrar la lista simple
    public void MostrarLista() {
        Nodo aux = inicioLista;

        while (aux != null) {
            JOptionPane.showMessageDialog(null, "[" + aux.getInformacion() + "]-->");
            // System.out.print("[" + aux.getInformacion() + "]---->");
            aux = aux.getSiguiente();
        }

        // Lista = "";
    }

    // Mostrar la cola
    public void MostrarCola() {
        Nodo recorrido = inicioLista;
        String ColaInvertida = "";

        while (recorrido != null) {
            Lista += recorrido.getInformacion() + " ";
            recorrido = recorrido.getSiguiente();
        }

        String cadena[] = Lista.split(" ");

        for (int i = cadena.length - 1; i >= 0; i--) {
            ColaInvertida += " " + cadena[i];
        }
        JOptionPane.showMessageDialog(null, ColaInvertida);
        Lista = "";
    }

    // Insertar al final de la lista e Insertar en Cola
    public void Insertar(String info) {
        Nodo nuevo_nodo = new Nodo();

        nuevo_nodo.setInformacion(info);
        nuevo_nodo.setSiguiente(null);

        if (this.ListaVacia()) {
            this.inicioLista = nuevo_nodo;
            this.finLista = nuevo_nodo;
            tamano++;
        } else {
            // nuevo_nodo.setSiguiente(this.inicioLista);
            // this.setInicioLista(nuevo_nodo);
            this.finLista.setSiguiente(nuevo_nodo);
            this.setFinLista(nuevo_nodo);
            this.tamano++;
        }
    }

    // Eliminar al inicio de la lista & Extraer de la Cola
    public String Eliminar() {
        if (!this.ListaVacia()) {
            String informacion = inicioLista.getInformacion();
            if (this.inicioLista == this.finLista) {
                this.inicioLista = null;
                this.finLista = null;
                this.tamano--;
            } else {
                this.inicioLista = inicioLista.getSiguiente();
                this.tamano--;
            }
            return informacion;
        } else {
            return null;
        }
    }

    // getters
    public Nodo getFinLista() {
        return finLista;
    }

    public Nodo getInicioLista() {
        return inicioLista;
    }

    public String getLista() {
        return Lista;
    }

    public int getTamano() {
        return tamano;
    }

    // setters
    public void setFinLista(Nodo finLista) {
        this.finLista = finLista;
    }

    public void setInicioLista(Nodo inicioLista) {
        this.inicioLista = inicioLista;
    }

    public void setLista(String lista) {
        Lista = lista;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

}

public class Nodo {

    // atributos
    private int dato;
    private char num;
    private String informacion;
    private Nodo siguiente;

    // constructor vacio
    public Nodo() {
    }

    // getters
    public char getNum() {
        return num;
    }

    public String getInformacion() {
        return informacion;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public int getDato() {
        return dato;
    }

    // setters
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public void setNum(char num) {
        this.num = num;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
}

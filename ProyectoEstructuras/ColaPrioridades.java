import javax.swing.JOptionPane;

public class ColaPrioridades extends ListaEnlazada{
    
    public ColaPrioridades(){
        super();
    }    

    public void insertar(int num, String nombre) {
        Nodo nuevo_nodo = new Nodo();

        nuevo_nodo.setDato(num);
        nuevo_nodo.setInformacion(nombre);
        nuevo_nodo.setSiguiente(null);

        if (this.ListaVacia()) {
            this.setInicioLista(nuevo_nodo);
            this.setTamano(this.getTamano()+1);;
        } else {
            nuevo_nodo.setSiguiente(this.getInicioLista());
            this.setInicioLista(nuevo_nodo);
            this.setTamano(this.getTamano()+1);;
        }
    }

    public int buscarMayor(){
        Nodo aux = this.getInicioLista();

        int valor = -1;
        while(aux != null){
            if(aux.getDato() > valor){
                valor = aux.getDato();
            }
            aux = aux.getSiguiente();
        }

        return valor;
    }

    public boolean buscar(int referencia){
        Nodo aux = this.getInicioLista();
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (referencia == aux.getDato()){
                encontrado = true;
            }
                aux = aux.getSiguiente();
        }
        return encontrado;
    }

    public Nodo removerPorPrioridad(){
        int referencia = this.buscarMayor();
        if (buscar(referencia)) {
            if (this.getInicioLista().getDato() == referencia) {
                Nodo aEliminar = this.getInicioLista();
                this.setInicioLista(this.getInicioLista().getSiguiente());
                this.setTamano(this.getTamano()-1);
                return aEliminar;
            } else{
                Nodo aux = this.getInicioLista();
                while(aux.getSiguiente().getDato() != referencia){
                    aux = aux.getSiguiente();
                }
                Nodo aeliminar = aux.getSiguiente();
                Nodo siguiente = aux.getSiguiente().getSiguiente();
                aux.setSiguiente(siguiente);  
                this.setTamano(this.getTamano()-1);
                return aeliminar;
            }
        }
        return null;
    }

    public void imprimir() {
        Nodo reco = this.getInicioLista();
        System.out.println("Listado de todos los elementos de la Cola.");
        while (reco != null) {
            JOptionPane.showMessageDialog(null, "[" + reco.getInformacion()+"-"+reco.getDato() + "]-->");
            System.out.println("Paciente: " +reco.getInformacion() +" Edad: "+reco.getDato());
            reco = reco.getSiguiente();
        }
        System.out.println();
    }

}

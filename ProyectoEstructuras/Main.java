import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        int opcionMenu1 = 0; // Menu general
        int opcionMenu2 = 0; // Menu Interno
        int opcionMenu3 = 0; // Menu cola prioridades

        String nodo_informacion = "";

        ListaEnlazada listaEnlazada = new ListaEnlazada();

        ColaPrioridades colaP = new ColaPrioridades();

        do {
            try {
                // Menu para elegir el funcionamiento de la lista enlazada

                opcionMenu1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu de opciones\n\n"
                        + "1. Lista Simple\n" + "2. Pila\n" + "3. Cola\n" + "4. Cola de Prioridades\n" + "5. Salir"));

                switch (opcionMenu1) {

                    case 1:
                        // Funcionamiento de Lista Simple
                        do {

                            opcionMenu2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "LISTA SIMPLE\n\n" + "1. Insertar un elemento\n" + "2. Borrar un elemento \n"
                                            + "3. Mostrar lista\n" + "4. Mostrar tamaño de la lista\n"
                                            + "5. Volver al menu principal"));

                            switch (opcionMenu2) {
                                case 1:
                                    nodo_informacion = JOptionPane.showInputDialog(null,
                                            "Inserte un elemento a la lista");
                                            // int nodo_pos = 0;
                                            // if(listaEnlazada.getTamano() >= 2){
                                            //     nodo_pos = Integer.parseInt(JOptionPane.showInputDialog(null,
                                            //             "ingrese la posicion donde va ingresar un elemento a la lista"));
                                            // }
                                    listaEnlazada.Insertar(nodo_informacion);
                                    break;

                                case 2:
                                    if (listaEnlazada.getTamano() == 0) {
                                        JOptionPane.showMessageDialog(null, "Lista Vacia. No se puede borrar");
                                    } else {
                                        listaEnlazada.Eliminar();
                                        JOptionPane.showMessageDialog(null, "Se elimino el nodo con exito");
                                    }
                                    break;

                                case 3:
                                    listaEnlazada.MostrarLista();
                                    break;

                                case 4:
                                    JOptionPane.showMessageDialog(null, "El tamaño es de " + listaEnlazada.getTamano());
                                    break;
                                case 5:
                                    listaEnlazada.Limpiar();
                                    opcionMenu2 = 5;
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opcion no disponible");
                                    break;
                            }
                        } while (opcionMenu2 != 5);
                        break;

                    case 2:
                        String infija = JOptionPane.showInputDialog(null, "Ingrese la expresion a evaluar");
                        // JOptionPane.showMessageDialog(null, Evaluador.evaluar(infija));
                        JOptionPane.showMessageDialog(null, Evaluador.evaluar(infija) + "\n" + "El resultado es: "
                                + Evaluador.evaluarPostfija(Evaluador.evaluar(infija)));
                        break;

                    case 3:
                        // Funcionamiento de Cola
                        do {
                            opcionMenu2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "COLA (Taquilla)\n\n" + "1. Registrar cliente\n" + "2. Atender cliente\n"
                                            + "3. Mostrar cola\n" + "4. Mostrar clientes en espera\n"
                                            + "5. Volver al menu principal"));
                            switch (opcionMenu2) {
                                case 1:
                                    nodo_informacion = JOptionPane.showInputDialog(null,
                                            "Inserte un elemento a la lista");
                                    listaEnlazada.Insertar(nodo_informacion);
                                    break;
                                case 2:
                                    if (listaEnlazada.getTamano() == 0) {
                                        JOptionPane.showMessageDialog(null, "No hay turnos en la cola");
                                    } else {
                                        listaEnlazada.Eliminar();
                                        JOptionPane.showMessageDialog(null, "Turno revisado");
                                    }
                                    break;
                                case 3:
                                    listaEnlazada.MostrarCola();
                                    break;
                                case 4:
                                    JOptionPane.showMessageDialog(null, "El tamaño es de " + listaEnlazada.getTamano());
                                    break;
                                case 5:
                                    listaEnlazada.Limpiar();
                                    opcionMenu2 = 5;
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opcion no disponible");
                                    break;
                            }
                        } while (opcionMenu2 != 5);
                        break;

                    case 4:
                        do {
                            opcionMenu3 = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "COLA De PRIORIDADES\n\n" + "1. Registrar Paciente\n" + "2. Atender Paciente\n"
                                            + "3. Mostrar cola\n" + "4. Mostrar Paciente en espera\n"
                                            + "5. Volver al menu principal"));
                            switch (opcionMenu3) {
                                case 1:
                                    String nombre = JOptionPane.showInputDialog(null, "Inserte el nombre del paciente");
                                    int edad = Integer.parseInt(
                                            JOptionPane.showInputDialog(null, "Inserte la Gravedad del paciente\n"+"1. leve\n"+"2. lesion menor\n"+"3. moderado\n"+"4. grave\n"+"5. urgencia\n"));
                                    colaP.insertar(edad, nombre);
                                    break;
                                case 2:
                                    if (colaP.getTamano() == 0) {
                                        JOptionPane.showMessageDialog(null, "No hay turnos en la cola");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Paciente "
                                                + colaP.removerPorPrioridad().getInformacion() + " atendid@");
                                    }
                                    break;
                                case 3:
                                    colaP.imprimir();
                                    break;
                                case 4:
                                    JOptionPane.showMessageDialog(null, "El tamaño es de " + colaP.getTamano());
                                    break;
                                case 5:
                                    colaP.Limpiar();
                                    opcionMenu3 = 5;
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opcion no disponible");
                                    break;
                            }
                        } while (opcionMenu3 != 5);
                        break;
                    case 5:
                        // Salir
                        opcionMenu1 = 5;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no disponible");
                        break;
                }
            } catch (NumberFormatException e) {

            }

        } while (opcionMenu1 != 5);
    }
}

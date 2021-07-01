
public class Evaluador {

    public static String evaluar(String infija) {
        String postfija = convertir(infija);
        // System.out.println(evaluarPostfija("2 12 +"));
        System.out.println("La expresion PostFija es: " + postfija);
        // return evaluarPostfija(postfija);
        return "La expresion PostFija es: " + postfija;
    }

    private static String convertir(String infija) {
        String postfija = "";
        Pila pila = new Pila();
        String[] elements = infija.split(" ");
        // for (String element : elements) {
        //     System.out.println(element);
        // }

        for (int i = 0; i < elements.length; i++) {
            String letra = elements[i];
            if (esOperador(letra)) {
                // System.out.println("es operador" +letra);
                if (pila.ListaVacia()) {
                    pila.push(letra + " ");
                } else {
                    if (letra == ")") {
                            postfija = postfija + pila.pop() + " ";
                    } else {
                        if (prioridadEnExpresion(letra) > prioridadEnPila(pila.peek())) {
                            pila.push(letra);
                        } else {
                                postfija = postfija + pila.pop()+ " ";
                            pila.push(letra);
                        }
                    }
                }
            } else {
                // System.out.println("paila la esta cagando"+letra);
                postfija = postfija + letra + " ";
            }
        }
        while (!pila.ListaVacia()) {
            
                postfija += pila.pop() + " ";
        }
        return postfija.replaceAll("[()]", "");
    }

    private static boolean esOperador(String letra) {
        return (letra.equals("*") || letra.equals("^") || letra.equals("+") || letra.equals("/") || letra.equals("-") || letra.equals("(")
                || letra.equals(")") || letra.equals("sin")|| letra.equals("tan") );
    }

    private static int prioridadEnExpresion(String operador) {
        if (operador.equals("^") ||  operador.equals("sin") || operador.equals("tan") )
            return 4;
        if (operador.equals("*") || operador.equals("/"))
            return 2;
        if (operador.equals("+") || operador.equals("-"))
            return 1;
        if (operador.equals("("))
            return 5;
        return 0;
    }

    private static int prioridadEnPila(String operador) {
        if (operador.equals("^") ||  operador.equals("sin")||operador.equals("tan") )
        return 3;
    if (operador.equals("*") || operador.equals("/"))
        return 2;
    if (operador.equals("+") || operador.equals("-"))
        return 1;
    if (operador.equals("("))
        return 5;
    return 0;
    }

    public static double evaluarPostfija(String postfija) {
        Pila pila = new Pila();
        String[] elements = postfija.split(" ");
        
        for (int i = 0; i < elements.length; i++) {
            String letra = elements[i];
            if (!esOperador(letra)) {
                pila.push(letra);
            } else {
               
                // double num2 = Double.parseDouble(pila.pop());
                // double num1 = Double.parseDouble(pila.pop());
                double num3 = operacion(letra, pila);

                String valor = String.valueOf(num3);
                pila.push(valor);
            }
        }
        return Double.parseDouble(pila.peek());
    }

    private static double operacion(String letra, Pila pila) {
        if (letra.equals("sin")){
            return Math.sin(Math.toDegrees(Double.parseDouble(pila.pop())));
        }
        if (letra.equals("tan")){
            return Math.tan(Math.toDegrees(Double.parseDouble(pila.pop())));
        }
        if (letra.equals("*"))
            return Double.parseDouble(pila.pop()) * Double.parseDouble(pila.pop());
        if (letra.equals("/"))
            return Double.parseDouble(pila.pop()) / Double.parseDouble(pila.pop());
        if (letra.equals("+"))
            return Double.parseDouble(pila.pop()) + Double.parseDouble(pila.pop());
        if (letra.equals("-"))
            return Double.parseDouble(pila.pop()) - Double.parseDouble(pila.pop());
        if (letra.equals("^"))
            return Math.pow(Double.parseDouble(pila.pop()), Double.parseDouble(pila.pop()));
        return 0;
    }
}

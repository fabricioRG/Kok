package manejadores;

import java.util.Hashtable;
import analizadores.sym;

/**
 *
 * @author fabricio
 */
public class ManejadorParser {

    public static int DEFAULT_INTEGER = 404;

    public ManejadorParser() {
    }

    public void forward(int numero) {
        ManejadorInterfaz.getInstance().forward(numero);
    }

    public void backward(int numero) {
        ManejadorInterfaz.getInstance().backward(numero);
    }

    public void right(int numero) {
        ManejadorInterfaz.getInstance().right(numero);
    }

    public void left(int numero) {
        ManejadorInterfaz.getInstance().left(numero);
    }

    public void clears() {
        ManejadorInterfaz.getInstance().clears();
    }

    public void penup() {
        ManejadorInterfaz.getInstance().penup();
    }

    public void pendown() {
        ManejadorInterfaz.getInstance().pendown();
    }

    public void tocenter() {
        ManejadorInterfaz.getInstance().tocenter();
    }

    public void color(int numero, String hexa) {
        if (hexa != null) {
            ManejadorInterfaz.getInstance().color(0, hexa);
        } else {
            if (numero < 0 || numero > 9) {
                showMessege("Numero incorrecto, ingresa valores del 0 al 9");
            } else {
                ManejadorInterfaz.getInstance().color(numero, null);
            }
        }
    }

    public void positionxy(int x, int y) {
        ManejadorInterfaz.getInstance().positionxy(x, y);
    }

    public void positionx(int x) {
        ManejadorInterfaz.getInstance().positionx(x);
    }

    public void positiony(int y) {
        ManejadorInterfaz.getInstance().positiony(y);
    }

    public void hideturtle() {
        ManejadorInterfaz.getInstance().hideturtle();
    }

    public void showturtle() {
        ManejadorInterfaz.getInstance().showturtle();
    }

    public void toerase() {
        ManejadorInterfaz.getInstance().toerase();
    }

    public void todraw() {
        ManejadorInterfaz.getInstance().todraw();
    }

    public void showMessege(String error) {
        ManejadorInterfaz.getInstance().showMessege(error);
    }

    public void operacion() {
        Integer.parseInt("1");
    }

    public int singleAssignment(String name) {
        if (!ManejadorInterfaz.getInstance().getNumbers().containsKey(name)) {
            ManejadorInterfaz.getInstance().setNumber(name, 0);
            return ManejadorInterfaz.getInstance().getNumbers().get(name);
        } else {
            showMessege("No puedo tener dos variable con el mismo nombre");
            return 0;
        }
    }

    public int getResultFromAssignment(String name, int number) {
        ManejadorInterfaz.getInstance().setNumber(name, number);
        return ManejadorInterfaz.getInstance().getNumbers().get(name);
    }

    public int getResultOperationValue(String nombre, int number2, int option) {
        int number1 = 0;
        if (getValueFromTable(nombre) == DEFAULT_INTEGER) {
            return 0;
        } else {
            number1 = getValueFromTable(nombre);
            switch (option) {
                case 1:
                    return number1 + number2;
                case 2:
                    return number1 - number2;
                case 3:
                    return number1 * number2;
                case 4:
                    return number1 / number2;
                default:
                    return 0;
            }
        }
    }

    public int getResultOperation(int number1, int number2, int option) {
        switch (option) {
            case 1:
                return number1 + number2;
            case 2:
                return number1 - number2;
            case 3:
                return number1 * number2;
            case 4:
                return number1 / number2;
            default:
                return 0;
        }
    }

    public int getNegativeNumber(int number) {
        return -number;
    }

    public int getValueFromTable(String name) {
        if (ManejadorInterfaz.getInstance().getNumbers().getOrDefault(name, DEFAULT_INTEGER) == DEFAULT_INTEGER) {
            showMessege("No he encontrado la variable \"" + name + "\"");
            return 0;
        }
        return ManejadorInterfaz.getInstance().getNumbers().getOrDefault(name, DEFAULT_INTEGER);
    }

    public void addToTable(String name, int value, int option) {
        if (option == 0) {
            ManejadorInterfaz.getInstance().setNumber(name, value);
        } else {
            ManejadorInterfaz.getInstance().setNumber(name, value);
        }
    }

    public void repeat(int number, String entrada) {
        String read = entrada.substring(1, entrada.length() - 1) + " ";
        String salida = "";
        System.out.println(read);
        try {
            ManejadorInterfaz.getInstance().setInstructionByComandos(read, 1);
            for (int i = 0; i < number - 1; i++) {
                salida += read;
            }
            ManejadorInterfaz.getInstance().setInstructionByComandos(salida, 1);
        } catch (Exception e) {
        }
    }

    public void errorState(String valor, int fila, int columna, int state) {
        String error = "";
        System.out.println("Valor: " + valor + ", Estado: " + state);
        switch (state) {
            case sym.TEXTO_PARAM:
            case sym.IDENTIFICADOR:
                error = "Texto no esperado  ";
                break;
            case sym.MULTIPLICACION:
            case sym.DIVISION:
            case sym.SUMA:
            case sym.RESTA:
            case sym.IGUAL:
                error = "Operacion no esperada ";
                break;
            case sym.DIGITO:
            case sym.ENTERO:
                error = "Digito no esperado ";
                break;
            case sym.COMA:
                error = "Coma no esperada ";
                break;
            case sym.POSITIONXY:
            case sym.POSITIONX:
            case sym.POSITIONY:
            case sym.COLOR:
            case sym.BACKWARD:
            case sym.FORWARD:
            case sym.PENUP:
            case sym.PENDOWN:
            case sym.CLEARS:
            case sym.RIGHT:
            case sym.LEFT:
            case sym.HIDETURTLE:
            case sym.TODRAW:
            case sym.TOERASE:
            case sym.TOCENTER:
                error = "Instruccion no esperada";
                break;
            case sym.PAR_ABI:
            case sym.PAR_CER:
                error = "Signo no esperado ";
                break;
            case sym.COMENTARIO:
                error = "Comentario no esperado ";
                break;
            case sym.HEXADECIMAL:
                error = "Color hexadecimal no esperado ";
                break;
        }
        error += "<" + valor + ">. Linea: " + fila + " , Columna: " + columna + ".";
        showMessege(error);
    }

}

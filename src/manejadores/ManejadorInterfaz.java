package manejadores;

import analizadores.Lexer1;
import analizadores.Vector;
import analizadores.parser;
import java.io.StringReader;
import kok.InterfazKok;

/**
 *
 * @author fabricio
 */
public class ManejadorInterfaz {

    private static ManejadorInterfaz INSTANCE = null;
    private InterfazKok ik = null;

    private ManejadorInterfaz() {
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorInterfaz();
        }
    }

    public static ManejadorInterfaz getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public void setInstructionByComandos(String entrada) {
        if (entrada.isEmpty()) {
            String error = "COMANDOS vacio";
            showMessege(error);
        } else {
            String instruction = "";
            String[] lines = entrada.split("\\r?\\n");
            for (String line : lines) {
                instruction = line;
            }
//            System.out.println(instruction);
            StringReader sr = new StringReader(instruction);
            Lexer1 lexer = new Lexer1(sr);
            parser pars = new parser(lexer, ManejadorParser.getInstance());
            try {
                if (entrada.isEmpty()) {
                    throw new Exception("Entrada vacia, intente de nuevo");
                }
                pars.parse();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void forward(int numero) {
        double longitud = Math.abs(ik.getV1().getY() - ik.getV2().getY());
        double x = Math.sin(Math.toRadians(ik.getAnguloAnterior())) * longitud;
        double y = Math.cos(Math.toRadians(ik.getAnguloAnterior())) * longitud;
        System.out.println("Longitud: " + longitud);
        System.out.println("Angulo: " + ik.getV1().getAngulo());
        if (ik.isStarted()) {
            ik.getV1().setY(ik.getV1().getY() - y);
            ik.getV1().setX(ik.getV1().getX() + x);
            ik.setStarted(true);
        }
        ik.setAnguloAnterior(ik.getAnguloActual());
        ik.getV2().setY(ik.getV1().getY() - numero);
        ik.getV2().setX(ik.getV1().getX());
        ik.dibujar();
        System.out.println("forward: " + numero);
    }

    public void backward(int numero) {
        double longitud = Math.abs(ik.getV1().getY() - ik.getV2().getY());
        Vector vec = getVector(longitud, ik.getAnguloAnterior());
//        double x = Math.sin(Math.toRadians(ik.getAnguloAnterior())) * longitud;
//        double y = Math.cos(Math.toRadians(ik.getAnguloAnterior())) * longitud;
        System.out.println("Longitud: " + longitud);
        System.out.println("Angulo: " + ik.getV1().getAngulo());
        if (ik.isStarted()) {
            ik.getV1().setY(ik.getV1().getY() - vec.getY());
            ik.getV1().setX(ik.getV1().getX() + vec.getX());
            ik.setStarted(true);
        }
        ik.setAnguloAnterior(ik.getAnguloActual());
        ik.getV2().setY(ik.getV1().getY() + numero);
        ik.getV2().setX(ik.getV1().getX());
        ik.dibujar();
        System.out.println("backward: " + numero);
    }

    public Vector getVector(double longitud, double angulo) {
        double x = Math.sin(Math.toRadians(angulo)) * longitud;
        double y = Math.cos(Math.toRadians(angulo)) * longitud;
        Vector vector = new Vector(x, y);
        return vector;
    }

    public void right(int numero) {
        ik.setAnguloActual(numero);
        System.out.println("right: " + numero);
    }

    public void left(int numero) {
        ik.setAnguloActual(-numero);
        System.out.println("left: " + numero);
    }

    public void clears() {
        ik.clearAfflines();
        ik.clearLines();
        ik.setClears(true);
        ik.getV1().setXY(ik.INITIAL_POSITION);
        ik.getV2().setXY(ik.INITIAL_POSITION);
        ik.setAnguloAnterior(0);
        ik.setAnguloActual(0);
        ik.dibujar();
        ik.setClears(false);
        System.out.println("clears");
    }

    public void penup() {
        ik.setEdition(false);
        System.out.println("penup");
    }

    public void pendown() {
        ik.setEdition(true);
        System.out.println("pendown");
    }

    public void tocenter() {
        positionxy(ik.CENTER_X, ik.CENTER_Y);
        System.out.println("tocenter");
    }

    public void color(int numero, String hexa) {
        if (hexa != null) {
            System.out.println("Color Hexadecimal: " + hexa);
        } else {
            System.out.println("Color n: " + numero);
        }
    }

    public void positionxy(int x, int y) {
        if(x < 0 || y < 0 ){
            showMessege("No puedo recibir valores menores a 0");
        } else if (x > ik.PREFERED_WIDTH){
            showMessege("No puedo recibir valores mayores a " + ik.PREFERED_WIDTH);
        } else if (y > ik.PREFERED_HEIGHT){
            showMessege("No puedo recibir valores mayores a " + ik.PREFERED_HEIGHT);
        } else {
            ik.getV1().setX(x);
            ik.getV2().setX(x);
            ik.getV1().setY(y);
            ik.getV2().setY(y);
            ik.setEdition(false);
            ik.dibujar();
            ik.setEdition(true);
        }
        System.out.println("Position x: " + x + " y: " + y);
    }

    public void positionx(int x) {
        if(x < 0){
            showMessege("No puedo recibir valores menores a 0");
        } else if (x > ik.PREFERED_WIDTH){
            showMessege("No puedo recibir valores mayores a " + ik.PREFERED_WIDTH);
        } else {
            ik.getV1().setX(x);
            ik.getV2().setX(x);
            ik.getV1().setY(ik.getV2().getY());
            ik.setEdition(false);
            ik.dibujar();
            ik.setEdition(true);
        }
        System.out.println("Position x: " + x);
    }

    public void positiony(int y) {
        if(y < 0){
            showMessege("No puedo recibir valores menores a 0");
        } else if (y > ik.PREFERED_HEIGHT){
            showMessege("No puedo recibir valores mayores a " + ik.PREFERED_HEIGHT);
        } else {
            ik.getV1().setX(y);
            ik.getV2().setX(y);
            ik.getV1().setX(ik.getV2().getX());
            ik.setEdition(false);
            ik.dibujar();
            ik.setEdition(true);
        }
        System.out.println("Position y: " + y);
    }

    public void hideturtle() {
        ik.setShowTurtle(false);
        System.out.println("hideturtle");
    }

    public void showturtle() {
        ik.setShowTurtle(true);
        System.out.println("showturtle");
    }

    public void toerase() {
        System.out.println("toerase");
    }

    public void todraw() {
        System.out.println("todraw");
    }

    public void showMessege(String error){
        ik.getMensajesArea().setText(ik.getMensajesArea().getText() + error + "\n");
    }
    
    public void setInterfazKok(InterfazKok ik) {
        this.ik = ik;
    }

}

package manejadores;

import analizadores.Lexer1;
import analizadores.Vector;
import analizadores.parser;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.Hashtable;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import kok.InterfazKok;

/**
 *
 * @author fabricio
 */
public class ManejadorInterfaz {

    public static String FILE_EXTENSION = ".kok";
    public static String FILE_EXTENSION_NAME = "kok";
    public static String FILE_NAME = "KOK";
    private static ManejadorInterfaz INSTANCE = null;
    private Hashtable<String, Integer> numbers = null;
    private InterfazKok ik = null;
    private Color color = null;

    private ManejadorInterfaz() {
        numbers = new Hashtable<>();
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

    public void setInstructionByComandos(String entrada, int option) throws Exception {
        if (entrada.trim().isEmpty()) {
            String error = "COMANDOS vacio";
            showMessege(error);
        } else {
            String instruction = "";
            if (option == 1) {
                String[] lines = entrada.split("\\r?\\n");
                for (String line : lines) {
                    instruction = line + " \n";
                }
            } else {
                instruction = entrada;
            }
            StringReader sr = new StringReader(instruction);
            Lexer1 lexer = new Lexer1(sr);
            parser pars = new parser(lexer, new ManejadorParser());
            if (entrada.isEmpty()) {
                throw new Exception("Entrada vacia, intente de nuevo");
            }
            pars.parse();
        }
    }

    public void forward(int numero) {
        double longitud = Math.abs(ik.getV1().getY() - ik.getV2().getY());
        double x = Math.sin(Math.toRadians(ik.getAnguloAnterior())) * longitud;
        double y = Math.cos(Math.toRadians(ik.getAnguloAnterior())) * longitud;
        if (ik.isStarted()) {
            ik.getV1().setY(ik.getV1().getY() - y);
            ik.getV1().setX(ik.getV1().getX() + x);
            ik.setStarted(true);
        }
        ik.setAnguloAnterior(ik.getAnguloActual());
        ik.getV2().setY(ik.getV1().getY() - numero);
        ik.getV2().setX(ik.getV1().getX());
        ik.dibujar();
    }

    private void redibujar(double x, double y) {
        double indice = 2;
        double longitud = Math.abs(ik.getV1().getY() - ik.getV2().getY());
        double x1 = Math.sin(Math.toRadians(ik.getAnguloAnterior())) * longitud;
        double y1 = Math.cos(Math.toRadians(ik.getAnguloAnterior())) * longitud;
        if (ik.isStarted()) {
            ik.getV1().setY(ik.getV1().getY() - y1);
            ik.getV1().setX(ik.getV1().getX() + x1);
            ik.setStarted(true);
        }
        double x2 = ik.getV1().getX() - x;
        double y2 = ik.getV1().getY() - y;
        double distancia = Math.sqrt(Math.pow(x2, indice) + Math.pow(y2, indice));
        ik.setAnguloActual(getAngle(x2, y2), 1);
        ik.setAnguloAnterior(ik.getAnguloActual());
        ik.getV2().setY(ik.getV1().getY() - distancia);
        ik.getV2().setX(ik.getV1().getX());
        ik.dibujar();
    }

    private double getAngle(double x, double y) {
        double angulo = 0;
        double compl = 90;
        if (x == 0 && y != 0) {
            if (y > 0) {
                return 0;
            } else if (y < 0) {
                return 180;
            }
        } else if (y == 0 && x != 0) {
            if (x > 0) {
                return -90;
            } else if (x < 0) {
                return 90;
            }
        }
        if (x < 0 && y < 0) {
            angulo = compl + Math.toDegrees(Math.atan(y / x));
        } else if (x > 0 && y < 0) {
            angulo = Math.toDegrees(Math.atan(x / y)) - compl;
        } else if (x < 0 && y > 0) {
            angulo = compl + Math.toDegrees(Math.atan(y / x));
        } else if (x > 0 && y > 0) {
            angulo = compl - Math.toDegrees(Math.atan(x / y));
        }
        return angulo;
    }

    public void backward(int numero) {
        double angulo = ik.getAnguloActual();
        ik.setAnguloActual(ik.getAnguloActual() + 180, 1);
        forward(numero);
        ik.setAnguloActual(angulo, 1);
    }

    public Vector getVector(double longitud, double angulo) {
        double x = Math.sin(Math.toRadians(angulo)) * longitud;
        double y = Math.cos(Math.toRadians(angulo)) * longitud;
        Vector vector = new Vector(x, y);
        return vector;
    }

    public void right(int numero) {
        ik.setAnguloActual(numero, 0);
    }

    public void left(int numero) {
        ik.setAnguloActual(-numero, 0);
    }

    public void clears() {
        ik.clearAfflines();
        ik.clearLines();
        ik.clearColors();
        ik.setClears(true);
        ik.getV1().setXY(ik.INITIAL_POSITION);
        ik.getV2().setXY(ik.INITIAL_POSITION);
        ik.setAnguloAnterior(0);
        ik.setAnguloActual(0, 1);
        ik.dibujar();
        ik.setClears(false);
    }

    public void penup() {
        ik.setEdition(false);
    }

    public void pendown() {
        ik.setEdition(true);
    }

    public void tocenter() {
        positionxy(ik.CENTER_X, ik.CENTER_Y);
    }

    public void color(int numero, String hexa) {
        Color color = null;
        if (hexa != null) {
            try {
                color = Color.decode(hexa.replace("\n", "").trim());
            } catch (Exception e) {
                showMessege("No puedo reconocer ese color");
            }
        } else {
            switch (numero) {
                case 0:
                    color = Color.RED;
                    break;
                case 1:
                    color = Color.ORANGE;
                    break;
                case 2:
                    color = Color.YELLOW;
                    break;
                case 3:
                    color = Color.GREEN;
                    break;
                case 4:
                    color = Color.CYAN;
                    break;
                case 5:
                    color = Color.BLUE;
                    break;
                case 6:
                    color = Color.MAGENTA;
                    break;
                case 7:
                    color = Color.GRAY;
                    break;
                case 8:
                    color = Color.PINK;
                    break;
                case 9:
                    color = Color.BLACK;
                    break;
            }
        }
        ik.setColor(color);
    }

    public void positionxy(int x, int y) {
        if (x < 0 || y < 0) {
            showMessege("No puedo recibir valores menores a 0");
        } else if (x > ik.PREFERED_WIDTH) {
            showMessege("No puedo recibir valores mayores a " + ik.PREFERED_WIDTH);
        } else if (y > ik.PREFERED_HEIGHT) {
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
    }

    public void positionx(int x) {
        if (x < 0) {
            showMessege("No puedo recibir valores menores a 0");
        } else if (x > ik.PREFERED_WIDTH) {
            showMessege("No puedo recibir valores mayores a " + ik.PREFERED_WIDTH);
        } else {
            positionxy(x, (int) ik.getV2().getY());
        }
    }

    public void positiony(int y) {
        if (y < 0) {
            showMessege("No puedo recibir valores menores a 0");
        } else if (y > ik.PREFERED_HEIGHT) {
            showMessege("No puedo recibir valores mayores a " + ik.PREFERED_HEIGHT);
        } else {
            positionxy((int) ik.getV2().getX(), y);
        }
    }

    public void hideturtle() {
        ik.setShowTurtle(false);
    }

    public void showturtle() {
        ik.setShowTurtle(true);
    }

    public void toerase() {
        color = ik.getColor();
        ik.setColor(Color.WHITE);
    }

    public void todraw() {
        ik.setColor(color);
    }

    public void showMessege(String error) {
        ik.getMensajesArea().setText(ik.getMensajesArea().getText() + error + "\n");
    }

    public void setInterfazKok(InterfazKok ik) {
        this.ik = ik;
    }

    public Hashtable<String, Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(Hashtable<String, Integer> numbers) {
        this.numbers = numbers;
    }

    public void setNumber(String key, int value) {
        this.numbers.put(key, value);
    }

    public void saveFile(String text) {
        try {
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(ik);
            File fileName = file.getSelectedFile();

            if (fileName != null) {
                /*guardamos el archivo y le damos el formato directamente,
    * si queremos que se guarde en formato doc lo definimos como .doc*/
                FileWriter save = new FileWriter(fileName + FILE_EXTENSION);
                save.write(text);
                save.close();
                JOptionPane.showMessageDialog(null,
                        "El archivo se a guardado Exitosamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void openFile() {
        String aux = "";
        String texto = "";
        try {
            /**
             * llamamos el metodo que permite cargar la ventana
             */
            FileNameExtensionFilter ff = new FileNameExtensionFilter(FILE_NAME, FILE_EXTENSION_NAME);
            JFileChooser file = new JFileChooser();
            file.setFileFilter(ff);
            file.showOpenDialog(ik);
            /**
             * abrimos el archivo seleccionado
             */
            File fl = file.getSelectedFile();

            /**
             * recorremos el archivo, lo leemos para plasmarlo en el area de
             * texto
             */
            if (fl != null) {
                FileReader fr = new FileReader(fl);
                BufferedReader br = new BufferedReader(fr);
                while ((aux = br.readLine()) != null) {
                    texto += aux + "\n";
                }
                br.close();
                ik.getEdicionArea().setText(texto);
                ik.getEdicionArea().setEnabled(true);
                ik.getRunButton().setEnabled(true);
                ik.getClearButton().setEnabled(true);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
    }

}

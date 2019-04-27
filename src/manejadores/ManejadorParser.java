package manejadores;

/**
 *
 * @author fabricio
 */
public class ManejadorParser {

    private static ManejadorParser INSTANCE = null;

    private ManejadorParser() {
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorParser();
        }
    }

    public static ManejadorParser getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }
    
    public void forward(String numero){
        ManejadorInterfaz.getInstance().forward(Integer.parseInt(numero));
    }
    
    public void backward(String numero){
        ManejadorInterfaz.getInstance().backward(Integer.parseInt(numero));
    }
    
    public void right(String numero){
        ManejadorInterfaz.getInstance().right(Integer.parseInt(numero));
    }
    
    public void left(String numero){
        ManejadorInterfaz.getInstance().left(Integer.parseInt(numero));
    }
    
    public void clears(){
        ManejadorInterfaz.getInstance().clears();
    }
    
    public void penup(){
        ManejadorInterfaz.getInstance().penup();
    }
    
    public void pendown(){
        ManejadorInterfaz.getInstance().pendown();
    }
    
    public void tocenter(){
        ManejadorInterfaz.getInstance().tocenter();
    }
    
    public void color(String numero, String hexa){
        if(hexa != null){
            ManejadorInterfaz.getInstance().color(0, hexa);
        } else if (numero != null){
            ManejadorInterfaz.getInstance().color(Integer.parseInt(numero), null);
        }
    }
    
    public void positionxy(String x, String y){
        ManejadorInterfaz.getInstance().positionxy(Integer.parseInt(x), Integer.parseInt(y));
    }
    
    public void positionx(String x){
        ManejadorInterfaz.getInstance().positionx(Integer.parseInt(x));
    }
    
    public void positiony(String y){
        ManejadorInterfaz.getInstance().positiony(Integer.parseInt(y));
    }
    
    public void hideturtle(){
        ManejadorInterfaz.getInstance().hideturtle();
    }
    
    public void showturtle(){
        ManejadorInterfaz.getInstance().showturtle();
    }
    
    public void toerase(){
        ManejadorInterfaz.getInstance().toerase();
    }
    
    public void todraw(){
        ManejadorInterfaz.getInstance().todraw();
    }
    
    public void showMessege(String error){
        ManejadorInterfaz.getInstance().showMessege(error);
    }
    
}

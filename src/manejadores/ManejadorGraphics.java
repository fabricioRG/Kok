package manejadores;

import analizadores.Vector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import kok.InterfazKok;

/**
 *
 * @author fabricio
 */
public class ManejadorGraphics {

    private InterfazKok ik = null;
    
    public ManejadorGraphics(InterfazKok ik) {
        this.ik = ik;
    }
    
    public void addGraphic(){

            
            if (ik.isClears()) {
                
                ik.getPosx().setText(ik.getV1().getX() + "");
                ik.getPosy().setText(ik.getV1().getY() + "");
                ik.getPosAngulo().setText(ik.getAnguloAnterior() + "");

            } else {

                if (ik.isEdition()) {
                    Line2D line = new Line2D.Double(ik.getV1().getX(), ik.getV1().getY(), ik.getV2().getX(), ik.getV2().getY());
                    ik.getLines().add(line);
                    AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(ik.getAnguloAnterior()), line.getX1(), line.getY1());
                    ik.getAffines().add(at);
                    ik.getColores().add(ik.getColor());
                }

                Vector v = ManejadorInterfaz.getInstance().getVector(Math.abs(ik.getV1().getY() - ik.getV2().getY()), ik.getAnguloAnterior());
                ik.getPosx().setText((double) (ik.getV1().getX() + v.getX()) + "");
                ik.getPosy().setText((double) (ik.getV1().getY() - v.getY()) + "");
                ik.getPosAngulo().setText(ik.getAnguloActual() + "");

            }
            
    }
    
}

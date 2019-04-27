package analizadores;

/**
 *
 * @author fabricio
 */
public class Vector {

private double x;
private double y;
private double angulo;

    public Vector(double x, double y, double angulo) {
        this.x = x;
        this.y = y;
        this.angulo = angulo;
    }
    
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
        this.angulo = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public void setXY(Vector vector){
        this.x = vector.getX();
        this.y = vector.getY();
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
    
}

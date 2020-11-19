
package ProyectoU2;




public class Punto {
private  int x, y;

/**
 * Generar un punto en las coordenadas [0,0]
 */
    public Punto() {
        this.x = 0;
        this.y = 0;
    }
    /**
     * Generar un punto en las coordenadas (x, y)
     * @param x Coordenada x del punto
     * @param y Coordenada y del punto
     */
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
/**
 * Asignar valor de la coordenada x
 * @param x Coordenada en x
 */
public void setX(int x){
this.x=x;
}

/**
 * Obtener el valor de la coordenada x
 * @return x Coordenada x del punto
 */
public int getX(){
return this.x;
}

/**
 * Asignar valor de la coordenada y
 * @param y Coordenada en y
 */
public void setY(int y){
this.y=y;
}

/**
 * Obtener el valor de la coordenada y
 * @return  Coordenada en y del punto
 */
public int getY(){
return this.y;
}

}

import java.util.Observable;
import java.util.Observer;

public class OVelocidad implements Observer {
    View miVistaa = new View();

    /**
     * Método que se ejecuta cuando cambia la velocidad de un coche.
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {
        //Precisamos castear el objeto a Coche
        Coche obxC = (Coche) arg;
        miVistaa.muestraVelocidad(obxC.matricula, obxC.velocidad);
    }
}

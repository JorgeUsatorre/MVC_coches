import java.util.Observable;
import java.util.Observer;

public class ObsExceso implements Observer {
    private static final int LIMITE_VELOCIDAD = 120;

    /**
     * Método que se ejecuta cuando se actualiza la velocidad de un coche.
     * Verifica si la velocidad supera el límite de 120 km/h y en el caso de que la velocidad super el limite se muestra una alerta.
     *
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {
        Coche coche = (Coche) arg;
        if (coche.velocidad > LIMITE_VELOCIDAD) {
            mostrarAlerta();
        }
    }

    /**
     * Método que muestra una alerta de velocidad excedida.
     * Se utiliza un diálogo para mostrar el mensaje de alerta.
     */
    private void mostrarAlerta() {
        Dialog.vDialogo("Alerta: velocidad excedida!");
    }
}

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche con el modelo y la matrícula especificados y lo agrega al parking.
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Cambia la velocidad de un coche y notifica a los observadores del cambio.
     * @param matricula
     * @param v nueva velocidad
     */
    public void cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        //cambia
        setChanged();
        // notifica del cambio
        notifyObservers(getCoche(matricula));
    }

    /**
     * Busca coche segun matricula.
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Aumenta la velocidad de un coche y notifica a los observadores del cambio.
     * @param matricula
     */
    public void subirVelocidad(String matricula) {
        // busca el coche y sube la velocidad
        getCoche(matricula).velocidad = getCoche(matricula).velocidad + 10;
        // cambia el parametro
        setChanged();
        //notifica al observer
        notifyObservers(getCoche(matricula));
    }

    /**
     * Reduce la velocidad de un coche y notifica a los observadores del cambio.
     * @param matricula
     */
    public void bajarVelocidad(String matricula) {
        // busca el coche y sube la velocidad
        getCoche(matricula).velocidad = getCoche(matricula).velocidad - 10;
        // se da cuenta de que cambió
        setChanged();
        //notifica al observer
        notifyObservers(getCoche(matricula));

    }

    /**
     * Obtiene la velocidad de un coche según su matrícula.
     * @param matricula
     * @return
     */
    public Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}

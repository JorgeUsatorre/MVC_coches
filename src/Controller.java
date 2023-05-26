public class Controller {
    static Model miModelo = new Model();
    static View miVista = new View();
    public static void main(String[] args) {
        OVelocidad oVelocidad = new OVelocidad();
        miModelo.addObserver(oVelocidad);

        ObsExceso obsExceso = new ObsExceso();
        miModelo.addObserver(obsExceso);

        GUI.crearVentana();
    }

    /**
     * Crea un coche con el modelo y la matricula correspondiente.
     * Si el coche se crea correctamente, se muestra la velocidad.
     * @param modelo
     * @param matricula
     */
    public static void crearCoche(String modelo, String matricula){
        Coche aux = miModelo.crearCoche(modelo,matricula);
        if(aux!=null){
            miVista.muestraVelocidad(aux.matricula, aux.velocidad);
        }
    }

    /**
     * Reduce la velocidad del coche con la matrícula especificada.
     * @param matricula
     */
    public static void bajarVelocidad(String matricula){
        miModelo.bajarVelocidad(matricula);
    }

    /**
     * Aumenta la velocidad del coche con la matrícula especificada.
     * @param matricula
     */
    public static void aumentarVelocidad(String matricula){
        miModelo.subirVelocidad(matricula);
    }
}
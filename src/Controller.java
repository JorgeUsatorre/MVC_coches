public class Controller {
    static Model nuevModelo = new Model();
    static View nuevVista = new View();
    public static void main(String[] args) {
        GUI.crearVentana();
    }

    /***
     * Crea un coche mediante las variables nomdelo y matricula
     * @param matricula
     */
    public static void crearCoche(String modelo, String matricula){
        Coche aux = nuevModelo.crearCoche(modelo,matricula);
        if(aux!=null){
            nuevVista.muestraVelocidad(aux.matricula, aux.velocidad);
        }
    }
    /***
     * Baja la velocidad un coche ya creado anteriormente
     * @param matricula
     */
    public static void bajarVelocidad(String matricula){
        int aux = nuevModelo.bajarVelocidad(matricula);
        nuevVista.muestraVelocidad(matricula, aux);
    }
    /***
     * Sube la velocidad un coche ya creado anteriormente
     * @param matricula
     */
    public static void aumentarVelocidad(String matricula){
        int aux = nuevModelo.subirVelocidad(matricula);
        nuevVista.muestraVelocidad(matricula,aux);
    }

    /***
     * Busca un coche ya creado anteriormente
     * @param matricula
     */
    public static void buscarCoche(String matricula){
        Coche cocheobj = nuevModelo.getCoche(matricula);
        nuevVista.muestraCoche(cocheobj, matricula);
    }
}
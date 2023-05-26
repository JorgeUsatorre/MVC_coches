public class View {
    /**
     * Muestra la velocidad de un coche en un diálogo
     * @param matricula
     * @param v
     */
    void muestraVelocidad(String matricula, Integer v){
        Dialog.vDialogo("El coche " + matricula + " tiene una velocidad de: " + v + "km/h");
    }
}

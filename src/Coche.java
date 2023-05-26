public class Coche {
    String matricula;
    String modelo;
    Integer velocidad;

    /**
     * Constructor de la clase coche
     * @param modelo
     * @param matricula
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
    }
}

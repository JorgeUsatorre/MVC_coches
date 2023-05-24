public class View {
    void muestraVelocidad(String matricula, Integer v){
        Dialog.vDialogo("El coche " + matricula + " tiene una velocidad de: " + v + "km/h");
    }

    void muestraCoche(Coche aux, String matricula){
        if(aux==null){
            Dialog.vDialogo("No existe el coche con la matrícula: " + matricula);
        }
        else{
            Dialog.vDialogo("El " + aux.modelo + " con la matrícula: " + aux.matricula + " tiene una velocidad de: " + aux.velocidad +"km/h");
        }
    }
}
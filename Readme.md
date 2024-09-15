# Arquitectura MVC

Este programa implementa un sistema de gestión de coches utilizando el patrón MVC. Se ha añadido un nuevo observer, `ObsExceso`, que muestra una alerta cuando la velocidad de un coche supera los 120 km/h.

## Modificaciones:

- Se ha agregado la clase `ObsExceso` que implementa la interfaz `Observer`.
- Cuando se actualiza la velocidad de un coche, el nuevo observer verifica si supera los 120 km/h.
- Si la velocidad excede el límite, se muestra una alerta de "Velocidad Excedida" utilizando un diálogo, en el caso de que el coche no supere el velocidad límite el programa continua mostrando la velocidad del coche en cuestión.


---
## Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        - String matricula
        - String modelo
        - Integer velocidad
        --
        + Coche(modelo: String, matricula: String)
    }

    class Controller {
        - static Model miModelo
        - static View miVista
        --
        + main(args: String[]): void
        + crearCoche(modelo: String, matricula: String): void
        + bajarVelocidad(matricula: String): void
        + aumentarVelocidad(matricula: String): void
    }

    class Model {
        - static ArrayList<Coche> parking
        --
        + crearCoche(modelo: String, matricula: String): Coche
        + cambiarVelocidad(matricula: String, v: Integer): void
        + getCoche(matricula: String): Coche
        + subirVelocidad(matricula: String): void
        + bajarVelocidad(matricula: String): void
        + getVelocidad(matricula: String): Integer
    }
    
    class View {
        --
        + muestraVelocidad(matricula: String, v: Integer): void
    }

    class ObsExceso {
        - View miVista
        --
        + update(o: Observable, arg: Object): void
    }

    class GUI {
        --
        + crearVentana(): void
    }

    class Dialog {
        --
        + vDialogo(mensajito: String): void
    }

    Coche --> Model
    Controller --> Model
    Controller --> View
    Controller --> GUI
    Model --> Coche
    Model --> Observable
    View --> Dialog
    ObsExceso --> Observer
    ObsExceso --> Coche
```

---

## Diagrama de Secuencia

Ejemplo básico del procedimiento, sin utilizar los nombres de los métodos






```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    participant ObsExceso
    participant Dialog

    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Creado!
    deactivate Model
    Controller->>+View: Muestra la velocidad, porfa
    activate View
    View->>-View: Mostrando velocidad
    View-->>Controller: Listo!
    deactivate View
    Controller->>+ObsExceso: update(Observable, Coche)
    activate ObsExceso
    ObsExceso->>+Dialog: vDialogo("Alerta: Velocidad excedida!")
    activate Dialog
    Dialog-->>-ObsExceso: Alerta mostrada
    deactivate Dialog
    deactivate ObsExceso
```


El mismo diagrama con los nombres de los métodos

```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    participant ObsExceso
    participant Dialog

    Controller->>Model: crearCoche("Mercedes", "BXK 1234")
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>+View: muestraVelocidad("BXK 1234", velocidad)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean
    deactivate View
    Controller->>+ObsExceso: update(Observable, Coche)
    activate ObsExceso
    ObsExceso->>+Dialog: vDialogo("Alerta: Velocidad excedida!")
    activate Dialog
    Dialog-->>-ObsExceso: Alerta mostrada
    deactivate Dialog
    deactivate ObsExceso

```




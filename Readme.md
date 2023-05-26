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
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {+muestraVelocidad(String, Integer)}
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +getVelocidad(String)
      }
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
      
```

---

## Diagrama de Secuencia

Ejemplo básico del procedimiento, sin utilizar los nombres de los métodos


```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Creado!
    deactivate Model
    Controller->>+View: Muestra la velocidad, porfa
    activate View
    View->>-View: Mostrando velocidad
    View-->>Controller: Listo!
    deactivate View
```

El mismo diagrama con los nombres de los métodos

```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: crearCoche("Mercedes", "NDD 7785")
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>+View: muestraVelocidad("BXK 1234", velocidad)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean
    deactivate View
```
El creador va a implementar una interfaz, QUÉ LE VA A DECIR, QUÉ ES LO QUE TIENE QUE HACER.

Este patrón, cierra nuestro código a cualquier tipo de modificación, pero si la abre a extensión. Cumpliendo el
punto correspondiente de SOLID

"Este patrón es un creador de clases a nivel comportamental."

-----------------------------------------------------
CompleteFlow, junta factoryMethod y strategyPattern.


Creator (clase abstracta) --> Reporte. Define el qué se va hacer.

A los factory (pdf, y excelfactory) no le añadimos @Service, porque queremos nosotors realizar la
inyección de dependencias, y así evitamos que spring boot lo haga

//FOTO factory method

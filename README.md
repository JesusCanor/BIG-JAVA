Configuración gradle

- El proyecto sólo puede tener un settings.gradle
- Cada módulo/proyecto tiene un build.gradle asignado
- El apartado subprojects, aplica a todos sus hijos.
- La diferencia entre plugins y apply plugins, es que plugins no permite la aplicación condicional de plugins ni la configuración dinámica de versiones.
- El uso de plugins es una buena práctica para proyectos Gradle modernos al simplificar la declaración y aplicación de plugins

Pendiente
El bloque plugins y el bloque dependencies en un archivo build.gradle sirven a propósitos diferentes pero complementarios. Ambos son esenciales en la configuración de un proyecto Gradle, y aquí te explico cómo se relacionan y se diferencian:

Bloque plugins:

Propósito: Se utiliza para declarar y aplicar plugins al proyecto. Los plugins pueden agregar funcionalidades adicionales al proyecto, como tareas, extensiones y configuraciones.
Ejemplo: Al aplicar el plugin 'java', obtienes tareas como compileJava y test para compilar y probar tu código Java, respectivamente.
Cómo funciona: Cuando se aplica un plugin, este puede modificar la estructura del proyecto, agregar tareas, extensiones y configuraciones específicas.
Bloque dependencies:

Propósito: Se utiliza para declarar las dependencias del proyecto. Estas pueden ser bibliotecas externas, otros proyectos, archivos, etc. Las dependencias son esenciales para la compilación y ejecución del proyecto.
Ejemplo: Si estás construyendo una aplicación web con Spring Boot, podrías añadir una dependencia al framework Spring Boot en este bloque.
Cómo funciona: Gradle resolverá las dependencias declaradas (por ejemplo, descargando las bibliotecas necesarias) y las hará disponibles para el proyecto durante las fases de compilación y ejecución.
Relación entre plugins y dependencies:

Los plugins pueden añadir configuraciones de dependencia específicas. Por ejemplo, al aplicar el plugin 'java', se añaden configuraciones de dependencia como implementation, compileOnly, y testImplementation.

Algunos plugins están diseñados para trabajar con ciertas dependencias. Por ejemplo, el plugin org.springframework.boot de Spring Boot simplifica la construcción de aplicaciones Spring Boot y, al aplicarlo, es común añadir dependencias Spring Boot en el bloque dependencies.

Un plugin puede también añadir tareas que utilizan o procesan las dependencias del proyecto. Por ejemplo, el plugin 'java' añade tareas de compilación que usan las dependencias declaradas para compilar el código fuente del proyecto.

En resumen, mientras que el bloque plugins extiende y mejora las capacidades de un proyecto Gradle, el bloque dependencies declara las bibliotecas y otros componentes necesarios para compilar y ejecutar el proyecto. En la práctica, estos dos bloques a menudo trabajan juntos para configurar y definir el comportamiento de un proyecto.
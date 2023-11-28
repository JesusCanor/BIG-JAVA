Datos primitivos
=
Un dato primitivo no es un objeto

    //  
    Primitive type	Wrapper class
     ~~no nulo~~       nulo
    boolean	            Boolean
    byte	            Byte
    char	            Character
    float	            Float
    int	                Integer
    long	            Long
    short	            Short
    double	            Double
                        String


![Minimium, maximum and size of primitive types](tabla%20java.png)
--------  -----------------------

`String` puede ser inicializado como un dato primitivo, pero su implementación si es un objeto.

Inicialización de Variables
=
* La inicialización de variables a nivel de `clase` por defecto, serían:
    * byte, short, int, long -> `0`
    * float, double -> `0.0`
    * boolean -> `false`
    * char -> `''`
    * Cualquier wrapper -> `null`
--------  -----------------------
* La inicialización de variables a nivel de `método` por defecto, sería:
  * `Error de compilación`. No se inicializa por defecto.
  * En `Switch`, si no inicializamos antes una variable, pero dentro de este, le damos valor. No hay problema y funciona.
  * En `do-while` pasaría lo mismo. Si no se inicializa una variable en el método, pero se utiliza en el do esa asginación, no hay error de compilación, ya que este `siempre se utiliza al menos una vez`.
  * En búcles `for`, `for-each` y `while`, si la condición no se asegura en compilación que se vaya a cumplir, da error, y `habría que asegurar la inicialización`.

Autoboxing and unboxing
=
lets developers write cleaner code, making it easier to read. The following table lists the primitive types and their corresponding wrapper classes, which are used by the Java compiler for autoboxing and unboxing:


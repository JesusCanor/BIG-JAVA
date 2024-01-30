package com.example.basics.variables;

public class DatosPrimitivos {

    public static void main(String[] args) {

        byte b = 127;
        char c = 127;
        short s = 127;
        int i = 127;
        long l = 127;
        float f = 127;
        double d = 127;
        boolean isTrue = false;

        /*Type	Bits	Minimum Value	    Maximum Value
        byte	 8	       -128                127
        short	16	       -32768              32767
        int	    32	       -2147483648  	   2147483647
        long	64	    -9223372036854775808   9223372036854775807
        float	32	      -3.402823e38	       3.402823e38
        double	64	   -1.79769313486232e308   1.79769313486232e308
        char	16	'\u0000' (equivalent to 0)	'\uffff' (equivalent to 65535)
        */


        long l2 = 127l;
        long l3 = 127L;
        System.out.println("l2 = " + l2);
        System.out.println("l2 = " + l3);


        float f2 = 127f;
        float f3 = 127F;
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);


        double d2 = 127d;
        double d3 = 127D;
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);


        byte b4 = 0b1111111; // binary 127 prefix 0b
        System.out.println("b4 = " +b4);


        short s4 = 0177; //octal 127 - octal prefix 0 only
        System.out.println("s4 = " +s4);


        int i4 = 0x007F; //hexadecinmal 127 - hex prefix 0x
        System.out.println("i4 = " + i4);


        byte b5 = 'a'; //Esto es porque los carácteres están represantados numéricamente = 97
        //Esto se puede aplicar a cualquier tipo primitivo, excepto boolean
        char c5 = 97; //Esto es porque los carácteres están represantados numéricamente = a
        double d5 = 'a';
        System.out.println("b5 = " +b5);
        System.out.println("c5 = " +c5);
        System.out.println("d5 = " +d5);


        //Esta asignación puede ser bidireccional
        //Las letras minusculas en ASCII están antes que las mayúsculas
        byte b6 = 'a'; //97
        byte c6 = 'A'; //65
        System.out.println("b6 = " +b6);
        System.out.println("c6 = " +c6);


        byte b7 = '\u007F';
        char c7 = '\u007F';

        System.out.println("b7 = " +b7);
        System.out.println("c7 = " +c7);


        byte b8 = 0b1111111; //binary 127 prefix 0b
        double d8 = 127D;
        System.out.println("b8 = " +b8);
        System.out.println("d8 = " +d8);

        short s8 = 0177; // octal 127 - octal prefix 0 only
        System.out.println("s8 = " +s8);

        int i8 = 0x007F; // hexadecimal 127 - hex prefix 0x
        System.out.println("i8 = " +i8);


        byte b9 = 0b0000_0001; //No se puede 0b_0000_0001 debe ser 0b0_0000_0001
        char c9 = 0x0_07F;   // No se puede 0x_007F, necesitamos el 0 antes del _
        short s9 = 011_11;
        int i9 = 1_000_000; //No aplica un ejemplo como 1_000_00_0 ni 1_000_00.0
        long l9 = 1_000_000L; // No se puede _1_000_000L
        float f9 = 1_000.000_000f;
        double d9 = 1_000_000e10; //No se puede 1_000_000_e10

        System.out.println("b9 = " +b9);
        System.out.println("c9 = " +c9);
        System.out.println("s9 = " +s9);
        System.out.println("i9 = " +i9);
        System.out.println("l9 = " +l9);
        System.out.println("f9 = " +f9);
        System.out.println("d9 = " +d9);
    }
}

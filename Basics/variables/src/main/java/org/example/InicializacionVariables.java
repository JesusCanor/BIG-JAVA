package org.example;

public class InicializacionVariables {

    byte variableByte;
    Byte variableByteW;

    char variableChar;
    Character variableCharW;

    short variableShort;
    Short variableShortW;

    int variableInt;
    Integer variableIntW;

    long variableLong;
    Long variableLongW;

    float variableFloat;
    Float variableFloatW;

    double variableDouble;
    Double variableDoubleW;

    Boolean variableBooleanW;
    boolean variableBoolean;

    String variableStringW;
    String variableString;

    final String ARROW = " -> ";

    public static void main(String[] args) {

        InicializacionVariables variable = new InicializacionVariables();

        System.out.println("------- Instancia variables con su valor por defecto a nivel de clase ----------");
        System.out.print("variableByte = " + variable.variableByte + variable.ARROW);
        System.out.print("variableShort = " + variable.variableShort + variable.ARROW);
        System.out.print("variableInt = " + variable.variableInt + variable.ARROW);
        System.out.println("variableLong = " + variable.variableLong);
        System.out.print("variableFloat = " + variable.variableFloat + variable.ARROW);
        System.out.println("variableDouble = " + variable.variableDouble);
        System.out.println("variableBoolean = " + variable.variableBoolean);
        System.out.println("variableChar = " + variable.variableChar);

        System.out.print("variableByteWrapper = " + variable.variableByteW + variable.ARROW);
        System.out.print("variableShortWrapper = " + variable.variableShortW + variable.ARROW);
        System.out.print("variableIntegerWrapper = " + variable.variableIntW + variable.ARROW);
        System.out.print("variableLongWrapper = " + variable.variableLongW + variable.ARROW);
        System.out.print("variableFloatWrapper = " + variable.variableFloatW + variable.ARROW);
        System.out.print("variableDoubleWrapper = " + variable.variableDoubleW + variable.ARROW);
        System.out.print("variableBooleanWrapper = " + variable.variableBooleanW + variable.ARROW);
        System.out.print("variableString = " + variable.variableString + variable.ARROW);
        System.out.println("variableCharacterWrapper = " + variable.variableCharW);


        /*
        Error de compilación
        byte mainByte;
        Byte mainByteW;
        char mainChar;
        Character mainCharacterW;
        short mainShort;
        Short mainShortW;
        int mainInt;
        Integer mainIntegerW;
        long mainLong;
        Long mainLongW;
        float mainFloat;
        Float mainFloatW;
        double mainDouble;
        Double mainDoubleW;
        boolean mainBoolean;
        Boolean mainBooleanW;

        System.out.println("------- Instancia variables con su valor por defecto a nivel de main/métodos ----------");
        System.out.print("variableByte = " + mainByte + variable.ARROW);
        System.out.print("variableShort = " + mainShort + variable.ARROW);
        System.out.print("variableInt = " + mainInt + variable.ARROW);
        System.out.println("variableLong = " + mainLong);
        System.out.print("variableFloat = " + mainFloat + variable.ARROW);
        System.out.println("variableDouble = " + mainDouble);
        System.out.println("variableBoolean = " + mainBoolean);
        System.out.println("variableCharacterWrapper = " + mainCharW);

        System.out.print("variableByteWrapper = " + mainByteW + variable.ARROW);
        System.out.print("variableShortWrapper = " + mainShortW + variable.ARROW);
        System.out.print("variableIntegerWrapper = " + mainIntegerW + variable.ARROW);
        System.out.print("variableLongWrapper = " + mainLongW + variable.ARROW);
        System.out.print("variableFloatWrapper = " + mainFloatW + variable.ARROW);
        System.out.print("variableDoubleWrapper = " + mainDoubleW + variable.ARROW);
        System.out.print("variableBooleanWrapper = " + mainBooleanW + variable.ARROW);
        System.out.print("variableString = " + mainString + variable.ARROW);
        System.out.println("variableCharacterWrapper = " + mainCharacterW);
        */


    }

}

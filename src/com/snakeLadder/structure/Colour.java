package com.snakeLadder.structure;

public enum Colour {
    YELLOW,
    WHITE,
    RED,
    BLUE,
    GREEN;

    public static Colour getColourAtOrdinal(int ordinal){
        for(Colour colour : values()){
            if(colour.ordinal() == ordinal){
                return colour;
            }
        }
        throw new IllegalArgumentException("Invalid ordinal : " + ordinal);
    }

}
